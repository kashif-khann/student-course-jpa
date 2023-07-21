package com.StudentCourse.studentcourse.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentCourse.studentcourse.Entity.Course;
import com.StudentCourse.studentcourse.Entity.Student;
import com.StudentCourse.studentcourse.Repository.CourseRepository;
import com.StudentCourse.studentcourse.Repository.StudentRepository;

@Service
public class CourseService {
	private final CourseRepository courseRepository;
	private final StudentRepository studentRepository;
	
	public CourseService(CourseRepository courseRepository, StudentRepository studentRepository)
	{
		this.courseRepository =  courseRepository;
		this.studentRepository = studentRepository;
	}

	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}

	public Course addcourse(Course course) {
		// TODO Auto-generated method stub
		return courseRepository.save(course);
	}

	public Course findAndEnroll(Long courseId, Long studentId) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(courseId).get();
		Student student = studentRepository.findById(studentId).get();
		course.enrollStudent(student);
		
		return courseRepository.save(course);
	}

}
