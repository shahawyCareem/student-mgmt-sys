package com.careem.shahawy.studentsmgmtsys.Student;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            responses = @ApiResponse(responseCode = "200", description = "One page of students returned (paginated)"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<StudentEntity> getAllStudents(){
        return studentService.findAll();
    }

    @Operation(
            summary = "Get one student",
            responses = @ApiResponse(responseCode = "200", description = "One student returned"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public StudentEntity getStudent(@Valid @PathVariable int id){
        return studentService.findById(id);
    }

    @Operation(
            summary = "Create one student",
            responses = @ApiResponse(responseCode = "201", description = "One student is created and returned"))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public StudentEntity addStudent(@Valid @RequestBody StudentEntity student){
        return studentService.add(student);
    }

    @Operation(
            summary = "Update one student",
            responses = @ApiResponse(responseCode = "200", description = "One student is updated and returned"))
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public StudentEntity updateStudent(@Valid @PathVariable int id, @Valid @RequestBody StudentEntity student){
        student.setId(id);
        return studentService.update(student);
    }

    @Operation(
            summary = "Delete one student",
            responses = @ApiResponse(responseCode = "204", description = "One student is deleted"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteStudent(@Valid @PathVariable int id){
        studentService.deleteById(id);
    }
}
