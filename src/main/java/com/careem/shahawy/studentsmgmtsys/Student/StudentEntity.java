package com.careem.shahawy.studentsmgmtsys.Student;

import com.careem.shahawy.studentsmgmtsys.Course.CourseEntity;
import com.careem.shahawy.studentsmgmtsys.Teacher.TeacherEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade= CascadeType.PERSIST
    )
    @JoinTable(
            name = "teacher_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade= CascadeType.PERSIST
    )
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<CourseEntity> courses;
}
