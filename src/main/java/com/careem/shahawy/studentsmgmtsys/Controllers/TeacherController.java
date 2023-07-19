package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Teacher;
import com.careem.shahawy.studentsmgmtsys.Services.TeacherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@Validated
@ApiResponse(responseCode = "500", description = "Internal server error, this should not happen")
@Tag(name = "Teacher Controller", description = "Endpoint for retrieving and modifying teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Operation(
            summary = "Get all teachers",
            responses = @ApiResponse(responseCode = "200", description = "One page of teachers returned (paginated)"))
    @GetMapping("/")
    public List<Teacher> getAllTeachers(){
        return teacherService.findAll();
    }

    @Operation(
            summary = "Get one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher returned"))
    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id){
        return teacherService.findById(id);
    }

    @Operation(
            summary = "Create one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher is created and returned"))
    @PostMapping("/")
    public Teacher addSTeacher(Teacher teacher){
        return teacherService.add(teacher);
    }

    @Operation(
            summary = "Update one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher is updated and returned"))
    @PutMapping("/{id}")
    public Teacher updateTeacher(Teacher teacher){
        return teacherService.update(teacher);
    }

    @Operation(
            summary = "Delete one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher is deleted"))
    @DeleteMapping("/{id}")
    public void deleteTeacher(Teacher teacher){
        teacherService.delete(teacher);
    }
}
