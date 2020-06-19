package com.dxc.services;

import java.util.List;

import com.dxc.dao.IStudentDao;
import com.dxc.dao.StudentDaoImpl;
import com.dxc.pojos.Student;

public class StudentServiceImpl implements IStudentService {
	
	private IStudentDao dao=new StudentDaoImpl();

	@Override
	public List<Student> getAllStudents() {
		return dao.getAllStudents();
	}
	
	public void addStudent(Student s)
	{
		dao.addStudent(s);
	}
	
	public void updateName(int r, String n)
	{
		dao.updateName(r, n);
	}
	
	public void updatePercentage(int r, double d)
	{
		dao.updatePercentage(r, d);
	}
	
	public void removeStudent(int r)
	{
		dao.removeStudent(r);
	}
	
	public Student getStudent(int r)
	{
		return dao.getStudent(r);
	}
	public void colseConnection()
	{
		dao.colseConnection();
	}

}



