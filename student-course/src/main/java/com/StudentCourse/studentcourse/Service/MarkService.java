package com.StudentCourse.studentcourse.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.StudentCourse.studentcourse.DTO.MarksDTO;
import com.StudentCourse.studentcourse.Entity.Course;
import com.StudentCourse.studentcourse.Entity.Mark;
import com.StudentCourse.studentcourse.Entity.Student;
import com.StudentCourse.studentcourse.Repository.CourseRepository;
import com.StudentCourse.studentcourse.Repository.MarkRepository;
import com.StudentCourse.studentcourse.Repository.StudentRepository;

@Service
public class MarkService {
	

	    private final MarkRepository markRepository;
		private final StudentRepository studentRepository;
		private final CourseRepository courseRepository;

		public MarkService(MarkRepository markRepository, StudentRepository studentRepository, CourseRepository courseRepository)
		{
			this.markRepository = markRepository;
			this.studentRepository = studentRepository;
			this.courseRepository = courseRepository;
		}

//	    public Mark addMark(Mark mark) {
//	        return markRepository.save(mark);
//	    }

	    
		public Mark addMark(Long courseId, Long studentId, Mark marks) {
			// TODO Auto-generated method stub
			Course course = courseRepository.findById(courseId).get();
			Student student = studentRepository.findById(studentId).get();
//			
//		    // Associate the student and course with the mark
		    marks.setStudent(student);
		    marks.setCourse(course);

		    // Save the mark using the MarkService
		    return markRepository.save(marks);
			
		}


		
		
	    
	    public List<MarksDTO> getMarksRefined() {
	        List<Mark> marks = markRepository.findAll();
	        List<MarksDTO> markDTOList = new ArrayList<>();

	        for (Mark mark : marks) {
	            MarksDTO markDTO = new MarksDTO();
	            markDTO.setId(mark.getId());
	            markDTO.setMarks(mark.getMarks());
	            markDTO.setStudentId(mark.getStudent().getId());
	            markDTO.setCourse(mark.getCourse());

	            markDTOList.add(markDTO);
	        }

	        return markDTOList;
	    }


		public MarksDTO findAndUpdate(Long studentId, Long courseId,  int newMarks) {
			
			Mark mark = markRepository.getMarksByStudentIdAndCourseId(studentId, courseId);
			
			mark.setMarkse(newMarks);
			markRepository.save(mark);
			
			MarksDTO markDTO=new MarksDTO();
			
			markDTO.setId(mark.getId());
	        markDTO.setMarks(mark.getMarks());
	        markDTO.setStudentId(mark.getStudent().getId());
	        markDTO.setCourse(mark.getCourse());
	        
	            
			return markDTO;
		}

		
	    public List<MarksDTO> getStudentMarksForCourse(Long studentId, Long courseId) {
	        
	        List<Mark> marks = markRepository.findByStudentIdAndCourseId(studentId, courseId);

	        List<MarksDTO> markDTOList = new ArrayList<>();

	        for (Mark mark : marks) {
	            MarksDTO markDTO = new MarksDTO();
	            markDTO.setId(mark.getId());
	            markDTO.setMarks(mark.getMarks());
	            markDTO.setStudentId(mark.getStudent().getId());
	            markDTO.setCourse(mark.getCourse());

	            markDTOList.add(markDTO);
	        }

	        return markDTOList;
	    }


}
