package com.StudentCourse.studentcourse.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.StudentCourse.studentcourse.DTO.MarksDTO;
import com.StudentCourse.studentcourse.Entity.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {

 
    List<Mark> findByStudentIdAndCourseId(Long studentId, Long courseId);
    
    Mark getMarksByStudentIdAndCourseId(Long studentId, Long courseId);
    
}
