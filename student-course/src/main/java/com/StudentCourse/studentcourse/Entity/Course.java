package com.StudentCourse.studentcourse.Entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.JoinColumn;



@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "courses")
    Set<Student> enrolledStudents;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<Mark> marks;

    // Getters and setters

    public Set<Mark> getMarks() {
        return marks;
    }

	public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
      
    public void setId(Long id) {
		this.id = id;
	}

	public void setEnrolledStudents(Set<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

	public void enrollStudent(Student student) {
		// TODO Auto-generated method stub
		enrolledStudents.add(student);
		
	}

}


