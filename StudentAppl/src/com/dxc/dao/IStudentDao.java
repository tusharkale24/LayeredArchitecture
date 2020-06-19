package com.dxc.dao;

import java.util.List;

import com.dxc.pojos.Student;

public interface IStudentDao {
	
	public List<Student> getAllStudents();
	public void addStudent(Student s);
	public void updateName(int r, String n);
	public void updatePercentage(int r, double d);
	public void removeStudent(int r);
	public Student getStudent(int r);
	public void colseConnection();
}
