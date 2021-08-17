package com.annotation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String branch;
	private int fee;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public Student(int id, String name, String branch, int fee) {
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.fee = fee;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "ID = "+ id + " Name " + name + " Branch " + branch + " Fee " + fee;
	}
}
