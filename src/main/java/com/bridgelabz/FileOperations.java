package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileOperations {
    private static final String HOME = System.getProperty("user.dir");
    private static final String DIRECTORY = "Sample";
    Path homePath = Paths.get(HOME);

    public void checkFileExist() {
        System.out.println(Files.exists(homePath));
    }

    public void deleteFile() throws IOException {
        Path deleteFile = Paths.get(homePath + "/" + DIRECTORY);
        if (Files.exists(deleteFile)) Files.delete(deleteFile);
        System.out.println(Files.exists(deleteFile));
    }

    public void createDirectory() throws IOException {
        Path samplePath = Paths.get(homePath + "/" + DIRECTORY);
        Files.createDirectory(samplePath);
    }

    public static void main(String[] args) throws IOException {
        FileOperations fileOperations = new FileOperations();
        fileOperations.checkFileExist();
        fileOperations.deleteFile();
        fileOperations.createDirectory();
    }
}
