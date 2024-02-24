package com.objects.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Practical of hibernate Object States
//		Transient
//		Persistent
//		Detached
//		Removed
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
//		creating student object
		Student student=new Student();
		student.setId(1414);
		student.setName("Ram");
		student.setCity("Delhi");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		
//		After creating student object and setting its properties the student object is in Transient state
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(student);
		student.setName("Richa");
		tx.commit();
		session.close();
		student.setName("Sharma");
		System.out.println(student.getName());
		factory.close();
		

	}

}
