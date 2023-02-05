package com.secondlevelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.aman.onetomany.Answer;

public class secondDemo {
	public static void main(String[] args) {
	
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session1 = factory.openSession();
		
		Answer a1 = session1.get(Answer.class, 6);
		System.out.println(a1);
		
		session1.close();
		
		Session session2 = factory.openSession();
		
		Answer a2 = session2.get(Answer.class, 6);
		System.out.println(a2);
		
		session2.close();
		factory.close();
			
	}

}
