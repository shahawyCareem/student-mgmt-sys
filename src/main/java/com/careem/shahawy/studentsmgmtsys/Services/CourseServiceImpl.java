package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Course;
import com.careem.shahawy.studentsmgmtsys.Repositories.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public Course add(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public Course findById(int id) {
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Course> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void delete(Course course) {
        courseRepo.delete(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepo.save(course);
    }
}
