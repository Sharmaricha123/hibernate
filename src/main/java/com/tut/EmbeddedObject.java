package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddedObject {
	public static void main(String args[])
	{
		Configuration cfg=new  Configuration();
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
		
		Session session= factory.openSession();
		Transaction tx=session.beginTransaction();
		
//		object save
		session.save(student1);
		session.save(student2);
		
		
		tx.commit();
		session.close();
		factory.close();
		
	}

}
