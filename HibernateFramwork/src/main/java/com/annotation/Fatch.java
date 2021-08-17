package com.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Fatch {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/annotation/config.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
//		get data 
		Student student = (Student)session.get(Student.class, 2);
		System.out.println(student);
		
//		load data
		Employee emp = (Employee)session.load(Employee.class, 1);
		System.out.println(emp);
		
		
		Address add = (Address)session.load(Address.class, 1);
		System.out.println(add);

		session.save(student);
		session.save(emp);
		session.save(add);
		session.close();
		factory.close();

	}

}
