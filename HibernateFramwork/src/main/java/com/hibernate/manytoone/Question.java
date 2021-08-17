package com.hibernate.manytoone;

import java.util.List;

import javax.persistence.*;

@Entity
public class Question {

	@Id
	private int question_id;
	private String question;
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
