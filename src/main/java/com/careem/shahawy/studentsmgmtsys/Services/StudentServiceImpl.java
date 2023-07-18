package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Student;
import com.careem.shahawy.studentsmgmtsys.Repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student add(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void delete(Student student) {
        studentRepo.delete(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepo.save(student);
    }
}
