package com.careem.shahawy.studentsmgmtsys.Services;

import com.careem.shahawy.studentsmgmtsys.Entities.Teacher;

import java.util.List;

public interface TeacherService {
    public Teacher add(Teacher teacher);

    public Teacher findById(int id);

    public List<Teacher> findAll();

    public void delete(Teacher teacher);

    public Teacher update(Teacher teacher);
}
