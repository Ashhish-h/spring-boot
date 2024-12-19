package com.springboot.crudoperationsdemo.dao;

import com.springboot.crudoperationsdemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
    Repository annotations is a specialized annotations for repositories.
    - it supports component scanning, translate JDBC exceptions
 */

@Repository
public class StudentDAOImp implements StudentDao{

    // creating a entity manager
    private EntityManager entityManager;

    // injecting entity manager through constructor
    public StudentDAOImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
        If the transaction is successful, the changes will be committed to the database.
        If an error occurs and the transaction is rolled back, the changes will not be persisted in the database.
        The @Transactional annotation can be applied at the class level or method level.
        It provides data reliability and consistency.
     */
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);   // persist is a method in EntityManager which is used to save a new entity in the database
    }
}
