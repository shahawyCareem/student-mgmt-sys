package com.careem.shahawy.studentsmgmtsys.Course;

import java.util.List;

public interface CourseService {
    public CourseEntity add(CourseEntity course);

    public CourseEntity findById(int id);

    public List<CourseEntity> findAll();

    public void delete(CourseEntity course);

    public void deleteById(int id);

    public CourseEntity update(CourseEntity course);
}
