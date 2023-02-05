package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.aman.onetomany.Answer;
import com.aman.onetomany.Question;

public class cascadeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		Question q1 = new Question();
		q1.setQuest_id(6);
		q1.setQuestion("what is cascade...?");
		
		Answer a1 = new Answer();
		a1.setAns_id(7);
		a1.setAnswer("first answer");
		
		Answer a2 = new Answer();
		a2.setAns_id(8);
		a2.setAnswer("second answer");
		
		List<Answer> list_ans = new ArrayList<Answer>();
		
		list_ans.add(a1);
		list_ans.add(a2);
		q1.setAns(list_ans);
		Transaction tx = session.beginTransaction();
		session.save(q1);
	
		tx.commit();
		
		session.close();
		factory.close();

	}

}
