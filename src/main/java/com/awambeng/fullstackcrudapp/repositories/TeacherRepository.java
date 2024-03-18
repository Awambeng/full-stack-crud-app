package com.awambeng.fullstackcrudapp.repositories;

import com.awambeng.fullstackcrudapp.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
