package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

public class FileOperationsTest {
    private static final String HOME = System.getProperty("user.dir");
    private static final String DIRECTORY = "Sample";
    Path homePath = Paths.get(HOME);

    @Test
    public void givenPathWhenCheckedShouldCheckFileExists() {
        Assert.assertTrue(Files.exists(homePath));
    }

    @Test
    public void givenPathWhenCheckedShouldCheckDeleted() {
        Path deleteFile = Paths.get(homePath+"/"+DIRECTORY);
        if(Files.exists(deleteFile)) FileUtils.deleteFiles(deleteFile.toFile());
        Assert.assertTrue(Files.notExists(deleteFile));
    }

    @Test
    public void givenPathWhenCheckedShouldAddDirectory() throws IOException {
        Path directory = Paths.get(homePath+"/"+DIRECTORY);
        Files.createDirectory(directory);
        Assert.assertTrue(Files.exists(directory));
    }

    @Test
    public void givenPathWhenCheckedShouldAddFiles(){
        IntStream.range(1,6).forEach(counter -> {
            Path files = Paths.get(homePath+"/"+DIRECTORY+"/temp"+counter);
            Assert.assertTrue(Files.notExists(files));
            try {
                Files.createFile(files);
            }catch (IOException ie){
                Assert.assertTrue(Files.exists(files));
            }
        });
    }

    @Test
    public void givenPathWhenCheckedShouldListFiles() throws IOException {
        Path listFiles = Paths.get(homePath+"/"+DIRECTORY);
        Files.list(listFiles).filter(Files::exists).forEach(System.out::println);
        Files.newDirectoryStream(listFiles, path -> path.toFile().isFile() && path.toString().
                startsWith("temp")).forEach(System.out::println);
    }
}