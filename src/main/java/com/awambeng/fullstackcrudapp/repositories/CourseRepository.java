package com.awambeng.fullstackcrudapp.repositories;

import com.awambeng.fullstackcrudapp.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
