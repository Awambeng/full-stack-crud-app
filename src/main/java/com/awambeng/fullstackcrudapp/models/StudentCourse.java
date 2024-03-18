package com.awambeng.fullstackcrudapp.models;

import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
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
        @JoinColumn(name = "student_id")
        Student student;

        @ManyToOne
        @JoinColumn(name = "course_id")
        Course course;

        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "Enrollment Date")
        private Date enrollDate;
}
