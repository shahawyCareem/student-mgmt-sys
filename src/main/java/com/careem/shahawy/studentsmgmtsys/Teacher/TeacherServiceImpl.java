package com.careem.shahawy.studentsmgmtsys.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public TeacherEntity add(TeacherEntity teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public TeacherEntity findById(int id) {
        return teacherRepo.findById(id).orElseThrow();
    }

    @Override
    public List<TeacherEntity> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void delete(TeacherEntity teacher) {
        teacherRepo.delete(teacher);
    }

    @Override
    public TeacherEntity update(TeacherEntity teacher) {
        return teacherRepo.save(teacher);
    }
}
