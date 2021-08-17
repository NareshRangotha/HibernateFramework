package com.hibernate.lifecycle;

import org.hibernate.Session; 
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

//		Practical of  Hibernate Object States:
//		1. Transient
//		2. Persistent
//		3. Detached
//		4. Removed
		
		SessionFactory f = new Configuration().configure("com/hibernate/lifecycle/config.xml").buildSessionFactory();


		Student s1 = new Student();
		s1.setName("Nitesh");
		s1.setCity("Hatod");
		Certificate c1 = new Certificate();
		c1.setCourse("React");
		c1.setDuration("2 month");
		s1.setCertificate(c1);
		
//		s1  in Transient state
		
		Session s = f.openSession();
		Transaction ts = s.beginTransaction();
		s.save(s1);
//		s1  in Persistent state :- s1 associate Session and DataBase 
		s1.setName("Atul");
		ts.commit();
		s.close();
//		3. Detached state
		s1.setName("Subham");
		System.out.print("After s.close();  "+s1); 
		f.close();
	}

}
