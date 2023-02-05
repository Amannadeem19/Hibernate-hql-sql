package com.Sql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.aman.onetomany.Answer;

public class sqlExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//SQL Query
		String s = "select * from Answer";
		
		NativeQuery nq	= session.createSQLQuery(s);
		List<Object []> answers= nq.list();
		for(Object[] array : answers) {
			
//			System.out.println(Arrays.toString(array));
			System.out.println(array[0] + " " + array[1] + " " + array[2]);
		}
		session.close();
		factory.close();
	}

}
