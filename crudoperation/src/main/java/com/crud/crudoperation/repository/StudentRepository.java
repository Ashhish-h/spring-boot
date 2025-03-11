package com.crud.crudoperation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudoperation.entity.Students;

public interface StudentRepository extends JpaRepository<Students, Integer> {

}
