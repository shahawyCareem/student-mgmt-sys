package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Course;
import com.careem.shahawy.studentsmgmtsys.Services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/")
    public List<Course> getAllCourse(){
        return courseService.findAll();
    }

    @Operation(
            summary = "Get one course",
            responses = @ApiResponse(responseCode = "200", description = "One course returned"))
    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.findById(id);
    }

    @Operation(
            summary = "Create one course",
            responses = @ApiResponse(responseCode = "200", description = "One course is created and returned"))
    @PostMapping("/")
    public Course addCourse(Course course){
        return courseService.add(course);
    }

    @Operation(
            summary = "Update one course",
            responses = @ApiResponse(responseCode = "200", description = "One course is updated and returned"))
    @PutMapping("/{id}")
    public Course updateCourse(Course course){
        return courseService.update(course);
    }

    @Operation(
            summary = "Delete one course",
            responses = @ApiResponse(responseCode = "200", description = "One course is deleted"))
    @DeleteMapping("/{id}")
    public void deleteCourse(Course course){
        courseService.delete(course);
    }
}
