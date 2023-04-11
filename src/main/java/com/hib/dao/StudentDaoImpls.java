package com.hib.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.model.Student;
import com.hib.util.HibernateUtil;

public class StudentDaoImpls implements StudentDao {
	Transaction transaction = null;
	Session session = null;
	Student student = null;

	@Override
	public void saveStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
	}

	@Override
	public Student getStudent(long id) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		student = session.get(Student.class, id);
		transaction.commit();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
		session.close();
		return student;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllstudent() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("from Student");
		List<Student> students = query.getResultList();
		return students;
	}

	@Override
	public Student updateStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.saveOrUpdate(student);
		transaction.commit();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
		return student;
	}

	@Override
	public void deleteStudent(Student student) {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(student);
		transaction.commit();
		if (transaction != null && transaction.isActive()) {
			transaction.rollback();
		}
	}

}
