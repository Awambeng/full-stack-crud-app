package com.awambeng.fullstackcrudapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Course_Name")
    private String courseName;

    @Column(name = "Description")
    private String description;

    @Column(name = "Course_Credit")
    private int courseCredit;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Start_Date")
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "End_Date")
    private Date endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Teacher_Id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course")
    List<StudentCourse> studentCourses;
}
