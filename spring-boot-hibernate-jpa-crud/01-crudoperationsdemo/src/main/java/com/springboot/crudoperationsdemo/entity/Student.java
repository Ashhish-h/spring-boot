package com.springboot.crudoperationsdemo.entity;

import jakarta.persistence.*;

// By marking a class Entity it means it will be going to store in a database
@Entity
@Table(name="student") // by this annotation we are specifying that the name of the table is student means add all the following data to the table student in the database
public class Student {  // @Table is not necessary if the class name is same as the table name

    // defining fields

    @Id // for primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // to generate the primary key
    @Column(name = "id") // actual name of the column in the database, not necessary if the name of the variable is same as the column name.
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // defining constructors
    public Student() {}

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getters/setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
