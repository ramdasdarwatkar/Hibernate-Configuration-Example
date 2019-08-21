package com.logicncode.hbtest;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.logicncode.hbtest.model.Student;
import com.logicncode.hbtest.util.HibernateUtil;

public class HibernateAppJavaConfiguration {

	public static void main(String[] args) 
	{
	
		// The First Way
		/*
		  Session session = HibernateUtil.getSessionFactory().openSession(); 
		  Transaction transaction = session.beginTransaction(); 
		  Student s = new Student(); 
		  s.setName("John");
		  s.setContact("9850739220"); 
		  session.save(s); 
		  transaction.commit(); 
		  session.close();
		  System.out.println("student added");
		  */
		
		// The Second Way
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) 
		{
			transaction = session.beginTransaction(); 
			 Student s = new Student(); 
			 s.setName("John");
			 s.setContact("9850739220"); 
			 session.save(s); 
			 transaction.commit(); 
			 session.close();
			 System.out.println("student added");
		}
		catch (Exception e) 
		{
			if(transaction != null)
			{
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}
		 
}

