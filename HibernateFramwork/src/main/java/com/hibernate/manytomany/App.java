package com.hibernate.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("com/hibernate/manytomany/config.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Emp emp1 = new Emp();
		Emp emp2 = new Emp();
		emp1.setEid(1);
		emp1.setEname("RAM");
		emp2.setEid(2);
		emp2.setEname("SHYAM");

		Project p1 = new Project();
		Project p2 = new Project();
		p1.setPid(1);
		p1.setPname("FEEDBACK SYSTEM");
		p2.setPid(2);
		p2.setPname("EXPERT MESSAGING");

		List<Emp> list1 = new ArrayList<Emp>();
		List<Project> list2 = new ArrayList<Project>();
		list1.add(emp1);
		list1.add(emp2);
		list2.add(p1);
		list2.add(p2);

		emp1.setProjects(list2);
		emp2.setProjects(list2);
		p1.setEmps(list1);
		p2.setEmps(list1);
		
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();

		session.save(emp1);
		session.save(emp2);
		session.save(p1);
		session.save(p2);
		ts.commit();
		session.close();
		factory.close();
	}

}
