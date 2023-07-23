package com.careem.shahawy.studentsmgmtsys.Student;

import com.careem.shahawy.studentsmgmtsys.Course.CourseEntity;
import com.careem.shahawy.studentsmgmtsys.Teacher.TeacherEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private int id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    private String name;

    @Column(name = "email")
    @NotNull
    @Email
    private String email;

    @Column(name = "gender")
    @NotNull
    @NotBlank
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
    @JsonIgnore
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
    @JsonIgnore
    private List<CourseEntity> courses;
}
