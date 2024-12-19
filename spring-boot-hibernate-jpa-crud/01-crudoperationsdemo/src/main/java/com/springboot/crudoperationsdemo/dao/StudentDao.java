package com.springboot.crudoperationsdemo.dao;

import com.springboot.crudoperationsdemo.entity.Student;

public interface StudentDao {
    void save(Student student);
    Student findById(Integer id);
}
