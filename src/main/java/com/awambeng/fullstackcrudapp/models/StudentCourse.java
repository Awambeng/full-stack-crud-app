package com.awambeng.fullstackcrudapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "Student_Id")
        private Student student;

        @ManyToOne
        @JoinColumn(name = "Course_Id")
        private Course course;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "Enrollment_Date")
        private Date enrollDate;
}