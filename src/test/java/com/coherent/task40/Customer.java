package com.coherent.task40;

import org.openqa.selenium.By;

public class Customer {
    public String name;
    public String position;
    public String office;
    public String age;
    public String salary;

    public Customer(String name, String position, String office, String age, String salary) {
        this.name = name;
        this.position = position;
        this.office = office;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", office='" + office + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
