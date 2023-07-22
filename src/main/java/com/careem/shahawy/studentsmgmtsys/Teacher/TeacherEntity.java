package com.careem.shahawy.studentsmgmtsys.Teacher;

import com.careem.shahawy.studentsmgmtsys.Course.CourseEntity;
import com.careem.shahawy.studentsmgmtsys.Student.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name="teachers")
public class TeacherEntity {

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
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<CourseEntity> courses;
}
