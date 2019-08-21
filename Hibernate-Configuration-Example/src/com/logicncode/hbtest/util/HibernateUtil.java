package com.logicncode.hbtest.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.logicncode.hbtest.model.Student;

import java.util.Properties;;

public class HibernateUtil 
{
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() 
	{
		if(sessionFactory == null)
		{
			try
			{
				Configuration configuration = new Configuration();
				
				Properties properties = new Properties();
				
				properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/anytest?useSSL=false");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                properties.put(Environment.HBM2DDL_AUTO, "update");
                
                configuration.setProperties(properties);
                configuration.addAnnotatedClass(Student.class);
                
                sessionFactory = configuration.buildSessionFactory();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
}
