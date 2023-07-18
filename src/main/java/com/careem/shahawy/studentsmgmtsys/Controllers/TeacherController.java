package com.careem.shahawy.studentsmgmtsys.Controllers;

import com.careem.shahawy.studentsmgmtsys.Entities.Teacher;
import com.careem.shahawy.studentsmgmtsys.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/")
    public List<Teacher> getAllTeachers(){
        return teacherService.findAll();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable int id){
        return teacherService.findById(id);
    }

    @PostMapping("/")
    public Teacher addSTeacher(Teacher teacher){
        return teacherService.add(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(Teacher teacher){
        return teacherService.update(teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(Teacher teacher){
        teacherService.delete(teacher);
    }
}
