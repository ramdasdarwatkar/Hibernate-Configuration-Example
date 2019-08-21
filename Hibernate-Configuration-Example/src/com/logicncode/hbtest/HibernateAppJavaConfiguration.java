package com.logicncode.hbtest;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
			 /*Student s = new Student(); 
			 s.setName("John");
			 s.setContact("9850739220"); 
			 session.save(s); 
			 transaction.commit(); 
			 session.close();
			 System.out.println("student added");*/
			
			
			/* For Multiple Records*/
			/*Query query = session.createQuery("FROM Student");
			List<Student> studentsList = query.list();
			
			System.out.println("name \t contact");
			
			for (Student student : studentsList) 
			{
				System.out.println(student.getName()+" - "+student.getContact());
			}*/
			
			/* For Single Record*/
			Student student = new Student();
			int id=2;
            student =  (Student) session.get(Student.class, id);
            System.out.println("My name is "+student.getName());
            
            /* update and delete*/
            /*
             student.setName("AMIT");
             // session.update(student);
             // session.saveOrUpdate(student);
             // session.delete(student);
             // session.remove(student);
            */

			 
	        
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

