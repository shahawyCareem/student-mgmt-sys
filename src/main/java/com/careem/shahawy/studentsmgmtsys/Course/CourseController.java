package com.careem.shahawy.studentsmgmtsys.Course;

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
@RequestMapping("/courses")
@Validated
@ApiResponse(responseCode = "500", description = "Internal server error, this should not happen")
@Tag(name = "Course Controller", description = "Endpoint for retrieving and modifying courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @Operation(
            summary = "Get all courses",
            responses = @ApiResponse(responseCode = "200", description = "One page of courses returned (paginated)"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/")
    public List<CourseEntity> getAllCourse(){
        return courseService.findAll();
    }

    @Operation(
            summary = "Get one course",
            responses = @ApiResponse(responseCode = "200", description = "One course returned"))
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public CourseEntity getCourse(@Valid @PathVariable int id){
        return courseService.findById(id);
    }

    @Operation(
            summary = "Create one course",
            responses = @ApiResponse(responseCode = "201", description = "One course is created and returned"))
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public CourseEntity addCourse(@Valid @RequestBody CourseEntity course){
        return courseService.add(course);
    }

    @Operation(
            summary = "Update one course",
            responses = @ApiResponse(responseCode = "200", description = "One course is updated and returned"))
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public CourseEntity updateCourse(@Valid @PathVariable int id, @Valid @RequestBody CourseEntity course){
        return courseService.update(course);
    }

    @Operation(
            summary = "Delete one course",
            responses = @ApiResponse(responseCode = "204", description = "One course is deleted"))
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteCourse(@Valid @PathVariable int id){
        courseService.deleteById(id);
    }
}
