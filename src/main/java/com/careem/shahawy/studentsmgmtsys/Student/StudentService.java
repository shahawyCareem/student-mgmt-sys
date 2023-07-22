package com.careem.shahawy.studentsmgmtsys.Student;

import java.util.List;

public interface StudentService {
    public StudentEntity add(StudentEntity student);

    public StudentEntity findById(int id);

    public List<StudentEntity> findAll();

    public void delete(StudentEntity student);

    public StudentEntity update(StudentEntity student);
}
