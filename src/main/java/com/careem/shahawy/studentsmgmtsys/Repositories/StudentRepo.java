package com.careem.shahawy.studentsmgmtsys.Repositories;

import com.careem.shahawy.studentsmgmtsys.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
