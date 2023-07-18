package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Course;

import java.util.List;

public interface CourseService {
    public Course add(Course course);

    public Course findById(int id);

    public List<Course> findAll();

    public void delete(Course course);

    public Course update(Course course);
}
