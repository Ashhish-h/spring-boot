package com.crud.crudoperation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.crud.crudoperation.entity.Students;
import com.crud.crudoperation.repository.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    // create method
    public Students addStudent(Students student) {
        return studentRepository.save(student);
    }

    // read method
    public List<Students> getAllStudents() {
        return studentRepository.findAll();
    }

    // update method
    public Students updateStudent(Students updatedStudent) {
        Optional<Students> existingSutdent = studentRepository.findById(updatedStudent.getStudent_id());
        Students student = existingSutdent.get();
        student.setStudent_class(12);
        student.setStudent_section("B");
        return studentRepository.save(student);
    }

    // delete method
    public boolean deleteStudent(int student_id) {
        studentRepository.deleteById(student_id);
        return true;
    }

}
