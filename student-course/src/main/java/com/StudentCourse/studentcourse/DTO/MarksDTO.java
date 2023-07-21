package com.StudentCourse.studentcourse.DTO;

import com.StudentCourse.studentcourse.Entity.Course;
import com.StudentCourse.studentcourse.Entity.Student;

import jakarta.persistence.ManyToOne;

public class MarksDTO {
    private Long id;


    private Long studentId;


    private Course course;

    private double marks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double d) {
		this.marks = d;
	}
    
    

}

