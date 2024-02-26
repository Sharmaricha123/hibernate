package com.mapping.xml;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
        Session session=factory.openSession();
        
        Person person=new Person(23,"Ram","Delhi","8765432901");
        Transaction tx=session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();
        factory.close();
	}

}
