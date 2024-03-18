package com.awambeng.fullstackcrudapp.repositories;

import com.awambeng.fullstackcrudapp.models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
}
