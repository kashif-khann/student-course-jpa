package com.StudentCourse.studentcourse.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.StudentCourse.studentcourse.DTO.StudentSubjectDTO;
import com.StudentCourse.studentcourse.Entity.Course;
import com.StudentCourse.studentcourse.Entity.Mark;
import com.StudentCourse.studentcourse.Entity.Student;
import com.StudentCourse.studentcourse.Repository.CourseRepository;
import com.StudentCourse.studentcourse.Repository.MarkRepository;
import com.StudentCourse.studentcourse.Repository.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final MarkRepository markRepository;
	
	public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, MarkRepository markRepository)
	{
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.markRepository = markRepository;
	}

	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	public Student findAndEnroll(Long courseId, Long studentId) {
		// TODO Auto-generated method stub
		Course course = courseRepository.findById(courseId).get();
		Student student = studentRepository.findById(studentId).get();
		student.enrollCourse(course);
		
		return studentRepository.save(student);
		
	}
	

    public List<StudentSubjectDTO> getAllStudentsWithSubjectNames() {
        List<Student> students = studentRepository.findAll();
        List<StudentSubjectDTO> dtos = new ArrayList<>();

        for (Student student : students) {
            StudentSubjectDTO dto = new StudentSubjectDTO();
            dto.setStudentId(student.getId());
            dto.setCourses(student.getCourses());

            dtos.add(dto);
        }

        return dtos;
    }

	
//    public List<StudentSubjectDTO> getAllStudentsWithSubjectNames() {
//        List<Student> students = studentRepository.findAll();
//        List<StudentSubjectDTO> dtos = new ArrayList<>();
//
//        for (Student student : students) {
//            StudentSubjectDTO dto = new StudentSubjectDTO();
//            dto.setStudentId(student.getId());
//            Set<Course> courses = student.getCourses();
//            StringBuilder subjectNames = new StringBuilder();
//
//            for (Course course : courses) {
//                subjectNames.append(course.getName()).append(", ");
//            }
//
//            // Remove the last comma and space
//            if (subjectNames.length() > 2) {
//                subjectNames.setLength(subjectNames.length() - 2);
//            }
//
//            dto.setSubjectName(subjectNames.toString());
//            dtos.add(dto);
//        }
//
//        return dtos;
//    }


	
	

}
