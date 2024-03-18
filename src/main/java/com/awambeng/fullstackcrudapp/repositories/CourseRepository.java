package com.awambeng.fullstackcrudapp.repositories;

import com.awambeng.fullstackcrudapp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
