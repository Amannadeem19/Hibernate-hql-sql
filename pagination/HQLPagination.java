package com.pagination;

import org.hibernate.query.*;

import com.aman.onetomany.Answer;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLPagination {

	public static void main(String[] args) {
		
	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session session = factory.openSession();
	Query query = session.createQuery("from Answer");
	
//	implementation of pagination using hibernate
	query.setFirstResult(0);
	query.setMaxResults(5);
	 List<Answer> answers= query.list();
	 
	 for(Answer a : answers) {
		 System.out.println("answer id:  " + a.getAns_id());
		 System.out.println("answers : " + a.getAnswer());
	 }
	
	session.close();
	factory.close();
	}
}
