package com.dxc.pojos;

public class Student {
	
	private int rollno;
	private String name;
	private double percentage;
	
	public Student() {
	}

	public Student(int rollno, String name, double percentage) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.percentage = percentage;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	public void display()
	{
		System.out.println(rollno+"  "+name+"  "+percentage);
	}
}




