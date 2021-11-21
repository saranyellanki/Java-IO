package com.bridgelabz;

public class EmployeePayroll {
    int id;
    String name;
    int salary;

    public EmployeePayroll(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public String toString(){
        return "Name:"+name+" Id:"+id+" Salary:"+salary;
    }
}
