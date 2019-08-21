package com.logicncode.hbtest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.logicncode.hbtest.model.Student;

public class HibernateAppXmlConfiguration {

	public static void main(String[] args) 
	{
	
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student s = new Student();
		s.setName("Pavan");
		s.setContact("8888605068");
		session.save(s);
		
		transaction.commit();
		session.close();
	}

}
