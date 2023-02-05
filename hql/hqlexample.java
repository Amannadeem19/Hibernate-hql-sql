package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.aman.onetomany.Answer;
import com.aman.onetomany.Question;


public class hqlexample {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		// hql 
		//syntax
		
//		for fetching 
		
		String query = "from Answer where ans_id =: x";
		Session session = factory.openSession();
		Query q = session.createQuery(query);
		q.setParameter("x", 1);
//		if single result - unique result
		
		//	if multiple result - list
		 List <Answer> list_answers= q.list();
		 System.out.println(list_answers);
		 for(Answer ans : list_answers) {
			 System.out.println("answer_id: " + ans.getAns_id());
			 System.out.println("answer : " + ans.getAnswer());			 
		 }
		 
//		 for deleting 
		 
//		 Transaction tx = session.beginTransaction();
//		 String del_query = "delete from Answer where ans_id =: x";
//		 Query q2 = session.createQuery(del_query);
//		 q2.setParameter("x", 1);
//		 int count = q2.executeUpdate();
//		 System.out.println("deleted rows : " +  count);
//		 tx.commit();
		 
//		 for update
		 
//		 Transaction tx = session.beginTransaction();
//		 Query q3 = session.createQuery("update Answer set answer =: x where ans_id =: y");
//		 q3.setParameter("x", "helpful in creating microservices");
//		 q3.setParameter("y", 2);
//		 int count = q3.executeUpdate();
//		 System.out.println("updated rows : " +  count);
//		 tx.commit();
//		 
//		 executing join query
		 
		Query q4 =  session.createQuery("Select q.question, q.quest_id, a.answer from Question q INNER JOIN q.ans as a");
		 
		List <Object []> result = q4.list();
		for(Object[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
		 
		 session.close();
		factory.close();
	}

}
