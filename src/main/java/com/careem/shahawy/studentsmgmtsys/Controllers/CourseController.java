package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Course;
import com.careem.shahawy.studentsmgmtsys.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/")
    public List<Course> getAllCourse(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public Course getCourse(@PathVariable int id){
        return courseService.findById(id);
    }

    @PostMapping("/")
    public Course addCourse(Course course){
        return courseService.add(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(Course course){
        return courseService.update(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(Course course){
        courseService.delete(course);
    }
}
