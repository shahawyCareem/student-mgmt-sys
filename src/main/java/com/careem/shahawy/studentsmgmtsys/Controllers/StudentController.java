package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Student;
import com.careem.shahawy.studentsmgmtsys.Services.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Validated
@ApiResponse(responseCode = "500", description = "Internal server error, this should not happen")
@Tag(name = "Student Controller", description = "Endpoint for retrieving and modifying students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Operation(
            summary = "Get all students",
            responses = @ApiResponse(responseCode = "200", description = "One page of students returned (paginated)"))@GetMapping("/")
    public List<Student> getAllStudents(){
        return studentService.findAll();
    }

    @Operation(
            summary = "Get one student",
            responses = @ApiResponse(responseCode = "200", description = "One student returned"))
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.findById(id);
    }

    @Operation(
            summary = "Create one student",
            responses = @ApiResponse(responseCode = "200", description = "One student is created and returned"))
    @PostMapping("/")
    public Student addStudent(Student student){
        return studentService.add(student);
    }

    @Operation(
            summary = "Update one student",
            responses = @ApiResponse(responseCode = "200", description = "One student is updated and returned"))
    @PutMapping("/{id}")
    public Student updateStudent(Student student){
        return studentService.update(student);
    }

    @Operation(
            summary = "Delete one student",
            responses = @ApiResponse(responseCode = "200", description = "One student is deleted"))
    @DeleteMapping("/{id}")
    public void deleteStudent(Student student){
        studentService.delete(student);
    }
}
