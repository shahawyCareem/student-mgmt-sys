package com.careem.shahawy.studentsmgmtsys.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepo courseRepo;

    @Override
    public CourseEntity add(CourseEntity course) {
        return courseRepo.save(course);
    }

    @Override
    public CourseEntity findById(int id) {
        return courseRepo.findById(id).orElseThrow();
    }

    @Override
    public List<CourseEntity> findAll() {
        return courseRepo.findAll();
    }

    @Override
    public void delete(CourseEntity course) {
        courseRepo.delete(course);
    }

    @Override
    public void deleteById(int id) {
        CourseEntity course = courseRepo.findById(id).orElseThrow();
        courseRepo.delete(course);
    }

    @Override
    public CourseEntity update(CourseEntity course) {
        return courseRepo.save(course);
    }
}
