package com.careem.shahawy.studentsmgmtsys.Teacher;

import java.util.List;

public interface TeacherService {
    public TeacherEntity add(TeacherEntity teacher);

    public TeacherEntity findById(int id);

    public List<TeacherEntity> findAll();

    public void delete(TeacherEntity teacher);

    public void deleteById(int id);

    public TeacherEntity update(TeacherEntity teacher);
}
