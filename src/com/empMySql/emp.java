package com.empMySql;

public class emp {
    private String name;
    private int age;
    private String salary;
    private int Id;

    public emp(String name, int age, String salary, int id) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        Id = id;
    }

    public emp() {
    }

    public emp(String name, int age, String salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public  int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
