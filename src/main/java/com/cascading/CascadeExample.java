package com.cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.oneTomany.Answer;
import com.map.oneTomany.Question;

public class CascadeExample {
	
	public static void main(String [] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		Session session=factory.openSession();
		
		Question q1=new Question();
		q1.setQuestionId(5625);
		q1.setQuestion("What is swing framework");
		
		Answer a1=new Answer(231,"use for development");
		Answer a2=new Answer(232,"desktop");
		Answer a3=new Answer(233,"learn by programmers");
		List<Answer>list=new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		Transaction tx=session.beginTransaction();
		
		session.save(q1);
		tx.commit();
		
		session.close();
		factory.close();
		
	}
	

}
