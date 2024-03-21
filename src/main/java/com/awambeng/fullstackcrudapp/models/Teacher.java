package com.awambeng.fullstackcrudapp.models;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Teacher_Name")
    private String name;

    @Column(name = "Teacher_Surname")
    private String surname;

    @Column(name = "Gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "Date_Of_Birth")
    private Date dateOfBirth;

    @Column(name = "Phone_Number")
    private String phoneNumber;

    @OneToMany(mappedBy = "teacher", cascade = {
            CascadeType.ALL
    })
    private List< Course > courses;
}

