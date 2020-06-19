package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.dxc.pojos.Student;

public class StudentDaoImpl implements IStudentDao {
	
	private static Connection conn;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	System.out.println("driver loaded...");
			
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tushar?autoReconnect=true&useSSL=false", "root", 
"password");
		//	System.out.println("connected to database....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAllStudents() {
		
		List<Student> list=new ArrayList<>();
		
		try {
			Statement stmt=conn.createStatement();
			ResultSet rset=stmt.executeQuery("select * from student");
			while(rset.next())
			{
				list.add(new Student(rset.getInt(1), rset.getString(2), rset.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void addStudent(Student s)
	{
		try {
			PreparedStatement pstmt=conn.prepareStatement("insert into Student values(?,?,?)");
			pstmt.setInt(1, s.getRollno());
			pstmt.setString(2, s.getName());
			pstmt.setDouble(3, s.getPercentage());
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateName(int r, String n)
	{
		try {
			PreparedStatement pstmt=conn.prepareStatement("update student set name=? where rollno=?");
			pstmt.setString(1, n);
			pstmt.setInt(2, r);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePercentage(int r, double d)
	{
		try {
			PreparedStatement pstmt=conn.prepareStatement("update student set percentage=? where rollno=?");
			pstmt.setDouble(1, d);
			pstmt.setInt(2, r);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeStudent(int r){
		try {
			PreparedStatement pstmt=conn.prepareStatement("delete from student where rollno=?");
			pstmt.setInt(1, r);
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Student getStudent(int r) {
		try {
			PreparedStatement pstmt=conn.prepareStatement("select * from student where rollno=?");
			pstmt.setInt(1, r);
			ResultSet rset=pstmt.executeQuery();
			
			if(rset.next())
			{
			Student s=new Student(rset.getInt(1),rset.getString(2),rset.getDouble(3));
			return s;
			}
			else 
				return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void colseConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

}








