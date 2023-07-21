package com.StudentCourse.studentcourse.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.StudentCourse.studentcourse.Entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
