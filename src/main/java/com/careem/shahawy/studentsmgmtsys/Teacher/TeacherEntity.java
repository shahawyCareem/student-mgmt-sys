package com.careem.shahawy.studentsmgmtsys.Teacher;

import com.careem.shahawy.studentsmgmtsys.Course.CourseEntity;
import com.careem.shahawy.studentsmgmtsys.Student.StudentEntity;
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
@Table(name="teachers")
public class TeacherEntity {

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
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
    private List<StudentEntity> students;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CourseEntity> courses;
}
