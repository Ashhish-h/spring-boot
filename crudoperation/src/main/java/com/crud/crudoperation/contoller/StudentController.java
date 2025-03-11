package com.crud.crudoperation.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.crud.crudoperation.entity.Students;
import com.crud.crudoperation.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Students addStudent(@RequestBody Students student) {
        return studentService.addStudent(student);
    }

    @GetMapping("/getStudents")
    public List<Students> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/updateStudent")
    public Students updateStudent(@RequestBody Students sutdent) {
        return studentService.updateStudent(sutdent);
    }

    @GetMapping("/deleteStudent/{student_id}")
    public boolean deleteStudent(@PathVariable int student_id) {
        return studentService.deleteStudent(student_id);
    }

}