package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Student;
import com.careem.shahawy.studentsmgmtsys.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/")
    public Student addStudent(Student student){
        return studentService.add(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(Student student){
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(Student student){
        studentService.delete(student);
    }
}
