package com.map.oneToone;

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
		
//		creating answer
		Answer a1=new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("Java is programming language");
		
		
//		creating question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is java?");
	    q1.setAnswer(a1);
	    
	    a1.setQuestion(q1);
	    
	    
////	creating answer
	Answer a2=new Answer();
	a2.setAnswerId(344);
	a2.setAnswer("API to work with objects in java");
		
////		creating question
		Question q2=new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is collection framework?");
		q2.setAnswer(a2);
		
		a2.setQuestion(q2);
		
		Session s=factory.openSession();
		Transaction tx= s.beginTransaction();
		
//		By saving the Answer object before associating it with the Question object, we ensure that the foreign key constraint is satisfied, and we avoid the constraint violation error.
		
		s.save(a1);
		s.save(q1);
		s.save(a2);
		s.save(q2);
		tx.commit();
		
//		fetching
		
		Question newq=(Question)s.get(Question.class, 242);
		System.out.println(newq.getQuestionId());
		System.out.println(newq.getQuestion());
		System.out.println(newq.getAnswer().getAnswerId());
		System.out.println(newq.getAnswer().getAnswer());
		
		s.close();
		factory.close();
	}

}
