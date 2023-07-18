package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Student;

import java.util.List;

public interface StudentService {
    public Student add(Student student);

    public Student findById(int id);

    public List<Student> findAll();

    public void delete(Student student);

    public Student update(Student student);
}
