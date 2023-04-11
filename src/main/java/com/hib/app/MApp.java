package com.hib.app;

import java.util.List;
import java.util.Scanner;

import com.hib.dao.StudentDao;
import com.hib.dao.StudentDaoImpls;
import com.hib.model.Student;

public class MApp {

	public static void main(String[] args) {
		MApp ap = new MApp();
		System.out.println("**********welcome to hibernate management system***********");
		ap.showmenu();
	}

	public void showmenu() {
		Scanner read = new Scanner(System.in);
		System.out.println("which operation you need to perform");
		System.out.println("\n1-saveStudent\n2-viewStudent\n3-viewAllStudent\n4-update\n5-delete\n6-exit");
		byte a = read.nextByte();
		switch (a) {
		case 1:
			insert();
			break;
		case 2:
			view();
			break;
		case 3:
			viewall();
			break;
		case 4:
			update();
			break;
		case 5:
			delete();
			break;
		case 6:
			System.exit(0);
			break;
		}
		read.close();
	}

	public void insert() {
		Student student = new Student();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the name");
		student.setName(read.next());
		System.out.println("Enter the age");
		student.setAge(read.nextInt());
		System.out.println("Enter the email");
		student.setEmail(read.next());
		System.out.println("Enter the pasword");
		student.setPassword(read.next());
		StudentDao dao = new StudentDaoImpls();
		dao.saveStudent(student);
		System.out.println("Record inserted successfully");
		showmenu();
		read.close();
	}

	public void view() {
		Student student = new Student();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the id");
		student.setId(read.nextLong());
		StudentDao dao = new StudentDaoImpls();
		student = dao.getStudent(student.getId());
		System.out.println(student.toString());
		showmenu();
		read.close();
	
	}

	public void viewall() {
		StudentDao dao = new StudentDaoImpls();
		List<Student> students=dao.getAllstudent();
		for(Student stu:students) {
			System.out.println(stu);
		}
		showmenu();
	}
		

	public void update() {
		Student student = new Student();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the old id");
		student.setId(read.nextLong());
		System.out.println("Enter the reset name");
		student.setName(read.next());
		System.out.println("Enter the reset age");
		student.setAge(read.nextInt());
		System.out.println("Enter the reset email");
		student.setEmail(read.next());
		System.out.println("Enter the reset pasword");
		student.setPassword(read.next());
		StudentDao dao = new StudentDaoImpls();
		dao.updateStudent(student);
		showmenu();
		read.close();

	}

	public void delete() {
		Student student = new Student();
		Scanner read = new Scanner(System.in);
		System.out.println("Enter the id");
		student.setId(read.nextLong());
		StudentDao dao = new StudentDaoImpls();
		dao.deleteStudent(student);
		System.out.println("record deleted successfully");
		showmenu();
		read.close();
	}

}
