package com.springboot.crudoperationsdemo.dao;

import com.springboot.crudoperationsdemo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void remove(Integer id);
    int removeAll();
}
