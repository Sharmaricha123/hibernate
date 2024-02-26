package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Certificate;
import com.tut.Student;

public class HQLPagination {
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
		
		Student student3=new Student();
		student3.setId(104);
		student3.setName("Ritik");
		student3.setCity("Bangalore");
		
		
		Certificate certificate3=new Certificate();
		certificate3.setCourse("Mern FullStack");
		certificate3.setDuartion("4 months");
		student3.setCerti(certificate3);
		
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(student1);
		session.save(student2);
		session.save(student3);
		tx.commit();
		
		Query<Student> query=session.createQuery("from Student",Student.class);
		
//		implementing pagination using hibernate
		
		query.setFirstResult(1);
		query.setMaxResults(2);
		
		List<Student> list=query.list();
		
		for(Student st:list)
		{
			System.out.println(st.getId()+" "+st.getName()+" "+st.getCity());
		}
		
		
		session.close();
		factory.close();
	}

}
