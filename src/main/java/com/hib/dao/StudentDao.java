package com.hib.dao;

import java.util.List;

import com.hib.model.Student;

public interface StudentDao {

	public void saveStudent(Student student);
	public Student getStudent(long id);
	public List<Student> getAllstudent();
	public Student updateStudent(Student student);
	public void deleteStudent(Student student);
	
}
