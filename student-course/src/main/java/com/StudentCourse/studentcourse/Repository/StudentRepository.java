package com.StudentCourse.studentcourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentCourse.studentcourse.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
