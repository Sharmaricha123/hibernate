package com.first.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;



public class SecondLevelCache {
	
	public static void main(String args[])
	{
	

		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(102);
		student1.setName("Richa");
		student1.setCity("Delhi");
		
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Java FullStack");
		certificate1.setDuartion("4 months");
		
		student1.setCerti(certificate1);
		
		
		Student student2=new Student();
		student2.setId(103);
		student2.setName("Reena");
		student2.setCity("Patna");
		
		
		Certificate certificate2=new Certificate();
		certificate2.setCourse("Python FullStack");
		certificate2.setDuartion("4 months");
		
		student2.setCerti(certificate2);
		Session s=factory.openSession();
		
		Transaction tx1=s.beginTransaction();
		s.save(student1);
		s.save(student2);
		tx1.commit();
		
		Session session1=factory.openSession();
		Student student11=(Student)session1.get(Student.class, 102);
		System.out.println(student11);
		session1.close();
		
		Session session2=factory.openSession();
		Student student12=(Student)session2.get(Student.class, 102);
		System.out.println(student12);
		session2.close();
		
		s.close();
		factory.close();
	}

}
