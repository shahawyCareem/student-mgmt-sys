package com.careem.shahawy.studentsmgmtsys.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    @Override
    public StudentEntity add(StudentEntity student) {
        return studentRepo.save(student);
    }

    @Override
    public StudentEntity findById(int id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public List<StudentEntity> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public void delete(StudentEntity student) {
        studentRepo.delete(student);
    }

    @Override
    public StudentEntity update(StudentEntity student) {
        return studentRepo.save(student);
    }
}
