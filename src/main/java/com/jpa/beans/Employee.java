package com.jpa.beans;

/**
 * Created with IntelliJ IDEA.
 * User: bnayar
 * Date: 2/10/14
 * Time: 2:46 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.persistence.*;

//@Entity
//@Table(name="Employee")
public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee() {}


    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(length=20, name = "first_name")
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @Column(length=20, name = "last_name")
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
}
