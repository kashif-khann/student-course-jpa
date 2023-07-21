package com.StudentCourse.studentcourse.DTO;

import java.util.Set;

import com.StudentCourse.studentcourse.Entity.Course;

public class StudentSubjectDTO {
	
    private Long studentId;
    private Set<Course> courses;
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

    

}
