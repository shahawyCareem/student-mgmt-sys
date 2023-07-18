package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Teacher;
import com.careem.shahawy.studentsmgmtsys.Repositories.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepo teacherRepo;

    @Override
    public Teacher add(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepo.delete(teacher);
    }

    @Override
    public Teacher update(Teacher teacher) {
        return teacherRepo.save(teacher);
    }
}
