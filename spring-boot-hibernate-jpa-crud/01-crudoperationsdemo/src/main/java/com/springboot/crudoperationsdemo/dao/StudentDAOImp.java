package com.springboot.crudoperationsdemo.dao;

import com.springboot.crudoperationsdemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Student findById(Integer id) { // Id is the primary key.
        return entityManager.find(Student.class, id); // This is the method in entityManager which takes the class name and primary key
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery(" from Student order by firstName asc ", Student.class);
        /*
            TypedQuery<> is an interface in JPQL - Jakarta Persistence Query Language which is platform independent. It
            is developed for performing query operations on Java Objects. Its syntax is similar to SQL.
            It provides methods for executing queries such as - getResultList(), executeUpdate(), getSingleList()
            createQuery is a method of entityManager which take entity name and entity class as arguments. Don't pass database name
            in first argument you write query using entity fields like lastname - from Students order by lastName asc
          */

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student>  query = entityManager.createQuery(
                "FROM Student WHERE lastName=:lastname", Student.class
                );
        query.setParameter("lastname", lastName);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int removeAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
