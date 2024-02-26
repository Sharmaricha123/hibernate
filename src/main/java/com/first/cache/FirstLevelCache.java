package com.first.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class FirstLevelCache {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(student1);
		session.save(student2);
		
		tx.commit();
		Student student11=session.get(Student.class, 102);
		System.out.println(student11);
		System.out.println("working something---------");
		Student student12=session.get(Student.class, 102);
		System.out.println(student12);
		System.out.println(session.contains(student1));
		
		
		session.close();
		factory.close();

	}

}
