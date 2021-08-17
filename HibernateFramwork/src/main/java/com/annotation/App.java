package com.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) throws IOException {

		Configuration cfg = new Configuration();
		cfg.configure("com/annotation/config.xml");

		SessionFactory factory = cfg.buildSessionFactory();

		Student std = new Student();
		std.setName("Naresh");
		std.setBranch("CSE");
		std.setFee(10000);

		Employee emp = new Employee();
		emp.setName("Atul");
		emp.setDepartment("IT");
		emp.setSlary(12500);

		Address address = new Address();
		address.setStreet("Street no 4");
		address.setCity("Indore");
		address.setOpen(true);
		address.setAddDate(new Date());
		address.setX(10.00);
//		reading image 
		FileInputStream fis = new FileInputStream("src/main/java/com/annotation/image.jpg");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		address.setImage(data);
		
		Session session = factory.openSession();

		Transaction ts = session.beginTransaction();

		session.save(std);
		session.save(emp);
		session.save(address);
		ts.commit();
		session.close();
	}

}
