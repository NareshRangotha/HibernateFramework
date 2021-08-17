package com.fetch.lazy.eager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/fetch/lazy/eager/config.xml");
		SessionFactory factory = cfg.buildSessionFactory();
				
		Session session = factory.openSession();
		
		Question q1 = (Question) session.get(Question.class, 1);
		Question q2 = (Question) session.get(Question.class, 2);

//		System.out.println(q1);
		System.out.println("Q No. "+q1.getQuestion_id());
		System.out.println("Q. "+q1.getQuestion());
		for(Answer a : q1.getAnswers())
		{
			System.out.println("Ans "+a.getAnswer());
		}
		System.out.println("Tolat no of ans "+q1.getAnswers().size());
		
//		System.out.println(q2);
		System.out.println("Q No. "+q2.getQuestion_id());
		System.out.println("Q. "+q2.getQuestion());
		for(Answer a : q2.getAnswers())
		{
			System.out.println("Ans "+a.getAnswer());
		}
		System.out.println("Tolat no of ans "+q2.getAnswers().size());
		
		session.close();
		factory.close();
	}

}
