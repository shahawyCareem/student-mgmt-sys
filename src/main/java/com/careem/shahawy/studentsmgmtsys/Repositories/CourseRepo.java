package com.careem.shahawy.studentsmgmtsys.Repositories;

import com.careem.shahawy.studentsmgmtsys.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
