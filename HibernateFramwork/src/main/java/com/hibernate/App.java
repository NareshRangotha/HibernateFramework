package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("com/hibernate/config.xml").buildSessionFactory();

		Student std1 = new Student();
		std1.setName("Naresh");
		std1.setCity("Ratlam");
		
		Emp emp1 = new Emp();
		emp1.setEmpname("Employee1");
		
		Certificate certi1 = new Certificate();
		certi1.setCourse("hibernate");
		certi1.setDuration("2 months");
		std1.setCertificate(certi1);

		Student std2 = new Student();
		std2.setName("Ajay");
		std2.setCity("Ratlam");
		
		Emp emp2 = new Emp();
		emp2.setEmpname("Employee2");
				
		Certificate certi2 = new Certificate();
		certi2.setCourse("Spring");
		certi2.setDuration("2 months");
		std2.setCertificate(certi2);

		Session session = factory.openSession();

		Transaction ts = session.beginTransaction();
		session.save(std1);
		session.save(emp1);
		session.save(std2);
		session.save(emp2);
		
		ts.commit();
		session.close();
		factory.close();
	}
}
