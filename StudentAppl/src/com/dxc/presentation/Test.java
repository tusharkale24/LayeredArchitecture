package com.dxc.presentation;
import java.util.List;
import java.util.Scanner;

import com.dxc.pojos.Student;
import com.dxc.services.IStudentService;
import com.dxc.services.StudentServiceImpl;

public class Test {
	public static void main(String[] args) {
		int choice;
		Scanner sc=new Scanner(System.in);
		IStudentService studentService = new StudentServiceImpl();
		while(true)
		{
			System.out.println("1.insert record");
			System.out.println("2.update record");
			System.out.println("3.delete record");
			System.out.println("4.display perticular record");
			System.out.println("5.display all records");
			System.out.println("6.exit");
			System.out.println("Enter choice");
			
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter rollno, name and percentage");
				studentService.addStudent(new Student(sc.nextInt(),sc.next(),sc.nextDouble()));
				break;
			case 2:
				System.out.println("Enter rollno of student that you want to update");
				int roll=sc.nextInt();
				System.out.println("1. to update name");
				System.out.println("2. to update percentage");
				int ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					System.out.println("Enter updated name");
					String n=sc.next();
					studentService.updateName(roll,n);
				case 2:
					System.out.println("Enter udpated percentage");
					double p=sc.nextDouble();
					studentService.updatePercentage(roll,p);
				}
				break;
			case 3:
					System.out.println("Enter roll number of student to be deleted");
					roll=sc.nextInt();
					studentService.removeStudent(roll);
				break;
			case 4:
				System.out.println("Enter roll number of student to be displayed");
				roll=sc.nextInt();
				Student stud=studentService.getStudent(roll);
				if(stud!=null)
					stud.display();
				else
					System.out.println("student with specified rollno not present..");
				break;
			case 5:
				List<Student> list=studentService.getAllStudents();
				for(Student s:list)
					s.display();
				System.out.println();
				break;
			case 6:
				studentService.colseConnection();
				System.exit(0);
			}
		}
		

	}

}
