package com.StudentCourse.studentcourse.Controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.StudentCourse.studentcourse.DTO.MarksDTO;
import com.StudentCourse.studentcourse.DTO.StudentSubjectDTO;
import com.StudentCourse.studentcourse.Entity.Course;
import com.StudentCourse.studentcourse.Entity.Mark;
import com.StudentCourse.studentcourse.Entity.Student;
import com.StudentCourse.studentcourse.Service.CourseService;
import com.StudentCourse.studentcourse.Service.MarkService;
import com.StudentCourse.studentcourse.Service.StudentService;

@RestController
public class ControllerX {
	

	private final StudentService studentService;
	private final CourseService courseService;
	private final MarkService markService;
	

	public ControllerX(StudentService studentService, CourseService courseService, MarkService markService)
	{
		this.studentService = studentService;
		this.courseService = courseService;
		this.markService = markService;
	}
	
	//add marks against a course
	@PostMapping("/addMark/student/{studentId}/course/{courseId}")
	Mark addMark(@PathVariable Long courseId,
    		@PathVariable Long studentId, 
    		@RequestBody Mark mark) {

	    return markService.addMark(courseId, studentId, mark);
	}
	

	//get all marks
    @GetMapping("/marks")
    List<MarksDTO> getMarks() {
        return markService.getMarksRefined();
    }
    

    //get specific marks for student and a course
    @GetMapping("/student/{studentId}/course/{courseId}/marks")
    List<MarksDTO> getStudentMarksForCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        return markService.getStudentMarksForCourse(studentId, courseId);
    }
	
    //get all students (DTO)
    @GetMapping("/studentsWithSubjectNames")
    List<StudentSubjectDTO> getAllStudentsWithSubjectNames() {
        return studentService.getAllStudentsWithSubjectNames();
    }
    


    //get all students
	@GetMapping("/students")
    List<Student> getStudents() {
        return studentService.getStudents();
    }

	
	//add a new student
    @PostMapping("/addStudent")
    Student createStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }
    
    //get all courses
	@GetMapping("/courses")
    List<Course> getCourse() {
        return courseService.getCourses();
    }

	//add a new course
    @PostMapping("/addCourse")
    Course createCourse(@RequestBody Course course) {
        return courseService.addcourse(course);
    }
    

    
    //set up a course for a student
    @PutMapping("student/{studentId}/course/{courseId}")
    Student enrollCourseToStudent(
    		@PathVariable Long courseId,
    		@PathVariable Long studentId
    		)
    {
    	return studentService.findAndEnroll(courseId, studentId);
    }
    
    
    //update marks for a student
    @PutMapping("student/{studentId}/course/{courseId}/marks/{newMarks}")
    MarksDTO updateMarks(
    		@PathVariable Long studentId,
    		@PathVariable Long courseId,
    		@PathVariable int newMarks
    		)
    {
    	return markService.findAndUpdate(studentId, courseId, newMarks);
    }
	



}
