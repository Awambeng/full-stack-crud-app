package com.awambeng.fullstackcrudapp.repositories;

import com.awambeng.fullstackcrudapp.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
