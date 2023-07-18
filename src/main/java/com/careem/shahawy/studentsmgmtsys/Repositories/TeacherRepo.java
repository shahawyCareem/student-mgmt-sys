package com.careem.shahawy.studentsmgmtsys.Repositories;

import com.careem.shahawy.studentsmgmtsys.Entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
}
