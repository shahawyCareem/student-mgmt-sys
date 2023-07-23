package com.careem.shahawy.studentsmgmtsys.Teacher;

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
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<TeacherEntity> getAllTeachers(){
        return teacherService.findAll();
    }

    @Operation(
            summary = "Get one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher returned"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public TeacherEntity getTeacher(@Valid @PathVariable int id){
        return teacherService.findById(id);
    }

    @Operation(
            summary = "Create one teacher",
            responses = @ApiResponse(responseCode = "201", description = "One teacher is created and returned"))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public TeacherEntity addSTeacher(@Valid @RequestBody TeacherEntity teacher){
        return teacherService.add(teacher);
    }

    @Operation(
            summary = "Update one teacher",
            responses = @ApiResponse(responseCode = "200", description = "One teacher is updated and returned"))
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public TeacherEntity updateTeacher(@Valid @PathVariable int id, @Valid @RequestBody TeacherEntity teacher){
        teacher.setId(id);
        return teacherService.update(teacher);
    }

    @Operation(
            summary = "Delete one teacher",
            responses = @ApiResponse(responseCode = "204", description = "One teacher is deleted"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteTeacher(@Valid @PathVariable int id){
        teacherService.deleteById(id);
    }
}
