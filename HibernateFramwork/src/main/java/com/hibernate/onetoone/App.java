package com.hibernate.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/onetoone/config.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestion_id(1);
		q1.setQuestion("What is java?");
//		creating a Answer obj
		
		Answer ans1 = new Answer();
		ans1.setAnswer_id(1);
		ans1.setAnswer("Java is pogramming language");
		ans1.setQuestion(q1);
		q1.setAnswer(ans1);
		
		Question q2 = new Question();
		q2.setQuestion_id(2);
		q2.setQuestion("What is collection framwork?");
//		creating a Answer obj
		
		Answer ans2 = new Answer();
		ans2.setAnswer_id(2);
		ans2.setAnswer("API to work with object in java");
		ans2.setQuestion(q2);
		q2.setAnswer(ans2);
		
		
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		session.save(q1);
		session.save(q2);
		session.save(ans1);
		session.save(ans2);
		ts.commit();
		session.close();
		factory.close();
	}

}
