package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchObject {
	public static void main(String[] args)
	{
		//get,load
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
//		it will fetch data from database
		Student student=(Student)session.get(Student.class, 101);
		System.out.println(student);
		
//	    it will fetch data from cache
		Student student1=(Student)session.get(Student.class, 101);
		System.out.println(student1);
		
//		load
		Address address=(Address)session.load(Address.class, 1);
		System.out.println(address.getCity()+":"+address.getStreet());
		
		session.close();
		factory.close();
	}

}
