package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project started" );
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        creating student
        Student st=new Student();
        st.setId(101);
        st.setName("Ritik");
        st.setCity("Bangalore");
        System.out.println(st);
        
        
//        creating address
        Address ad=new Address();
        ad.setStreet("stree1");
        ad.setCity("delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.234);
        
//        Reading Image
        FileInputStream fis=new FileInputStream("src/main/java/pic.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        
        
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
       
        
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
    }
}
