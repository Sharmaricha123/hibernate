package com.hql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.map.oneTomany.Answer;
import com.map.oneTomany.Question;
import com.tut.Certificate;
import com.tut.Student;





public class HQLExample {

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
		
		Student student3=new Student();
		student3.setId(104);
		student3.setName("Ritik");
		student3.setCity("Bangalore");
		
		
		Certificate certificate3=new Certificate();
		certificate3.setCourse("Mern FullStack");
		certificate3.setDuartion("4 months");
		student3.setCerti(certificate3);
		
//		creating question
		Question q11=new Question();
		q11.setQuestionId(1212);
		q11.setQuestion("What is java?");
		
		
//		creating answer
		Answer a1=new Answer();
		a1.setAnswerId(343);
		a1.setAnswer("With the help of java we can create softwares");
		a1.setQuestion(q11);
		
		Answer a2=new Answer();
		a2.setAnswerId(344);
		a2.setAnswer("Java is programming language");
		a2.setQuestion(q11);
		
		Answer a3=new Answer();
		a3.setAnswerId(345);
		a3.setAnswer("java has differnet type of frameworks");
		a3.setQuestion(q11);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q11.setAnswers(list);
	
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
 		
// 		object save
 		session.save(student1);
 		session.save(student2);
 		session.save(student3);
 		session.save(a1);
 		session.save(a2);
 		session.save(a3);
 		session.save(q11);
 		

// fetching data from db
 		
		String query="from Student ";
		String query1="from Student where city='Delhi'";
		String query2="from Student where city=:x and name=:n";
		Query q=session.createQuery(query);
		Query q1=session.createQuery(query1);
		Query q2=session.createQuery(query2);
		
		q2.setParameter("x", "Bangalore");
		q2.setParameter("n", "Ritik");

//		Single-(Unique)
//		Multiple list
		List<Student> lists=q2.list();

		for(Student student:lists)
		{
			System.out.println(student.getName()+":"+student.getCerti().getCourse());
		}
		
//		delete query
		
		Query q3=session.createQuery("delete from Student where city=:c");
		q3.setParameter("c", "Patna");
		int r=q3.executeUpdate();
		System.out.println(r+" "+"objects deleted");
		
//		update query
		
		Query q4=session.createQuery("update Student set city=:c where name=:n");
		q4.setParameter("c", "Karnataka");
		q4.setParameter("n", "Ritik");
		int r1=q4.executeUpdate();
		System.out.println(r1+" "+"objects updated");
		
		
//		execute join query
		
		Query q5=session.createQuery("Select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> list3=q5.getResultList();
		
		for(Object[] arr:list3)
		{
			System.out.println(Arrays.toString(arr));
		}
		tx.commit();

		session.close();
		factory.close();
		
	}

}
