package com.awambeng.fullstackcrudapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentCourseRepository extends JpaRepository<StudentRepository, Long> {
}
