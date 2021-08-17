package com.hibernate.manytoone;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/manytoone/config.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestion_id(1);
		q1.setQuestion("What is java?");
		Answer ans1 = new Answer();
		ans1.setAnswer_id(1);
		ans1.setAnswer("Java is a high-level, class-based, object-oriented programming language");
		ans1.setQuestion(q1);
		
		Answer ans2 = new Answer();
		ans2.setAnswer_id(2);
		ans2.setAnswer("java is compiled technology");
		ans2.setQuestion(q1);
		
		Answer ans3 = new Answer();
		ans3.setAnswer_id(3);
		ans3.setAnswer("Java is a widely used object-oriented programming language ");
		ans3.setQuestion(q1);
		
		List<Answer> list1 = new ArrayList<Answer>();
		list1.add(ans1);
		list1.add(ans2);
		list1.add(ans3);
		
		q1.setAnswers(list1);
//		question 2
		Question q2 = new Question();
		q2.setQuestion_id(2);
		q2.setQuestion("Features of java?");
		Answer ans4 = new Answer();
		ans4.setAnswer_id(4);
		ans4.setAnswer("Java is a Object-Oriented pogramming language");
		ans4.setQuestion(q2);
		
		Answer ans5 = new Answer();
		ans5.setAnswer_id(5);
		ans5.setAnswer("Platform independent");
		ans5.setQuestion(q2);
		
		Answer ans6 = new Answer();
		ans6.setAnswer_id(6);
		ans6.setAnswer("Architecture neutral");
		ans6.setQuestion(q2);
		
		List<Answer> list2 = new ArrayList<Answer>();
		list2.add(ans4);
		list2.add(ans5);
		list2.add(ans6);
		
		q2.setAnswers(list2);
		
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		
		session.save(q1);
		session.save(ans1);
		session.save(ans2);
		session.save(ans3);
		session.save(q2);
		session.save(ans4);
		session.save(ans5);
		session.save(ans6);
		ts.commit();
		session.close();
		factory.close();
	}

}
