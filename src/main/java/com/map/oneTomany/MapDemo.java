package com.map.oneTomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	public static void main(String [] args)
	{
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		

//		creating question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
		
		
//		creating answer
		Answer a1=new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("With the help of java we can create softwares");
		a1.setQuestion(q1);
		
		Answer a2=new Answer();
		a2.setAnswerId(344);
		a2.setAnswer("Java is programming language");
		a2.setQuestion(q1);
		
		Answer a3=new Answer();
		a3.setAnswerId(345);
		a3.setAnswer("java has differnet type of frameworks");
		a3.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
	
		Session s=factory.openSession();
		Transaction tx= s.beginTransaction();
		
//		By saving the Answer object before associating it with the Question object, we ensure that the foreign key constraint is satisfied, and we avoid the constraint violation error.
		
		s.save(a1);
		s.save(a2);
		s.save(a3);
		s.save(q1);
		
		tx.commit();
		
//		fetching
		
		Question newq=(Question)s.get(Question.class, 1212);
		System.out.println(newq.getQuestionId());
		System.out.println(newq.getQuestion());
		
		for(Answer a:newq.getAnswers())
		{
			System.out.println(a.getAnswer());
		}
		

		
		s.close();
		factory.close();
	}

}
