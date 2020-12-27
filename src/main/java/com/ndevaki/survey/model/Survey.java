package com.ndevaki.survey.model;

import java.util.ArrayList;
import java.util.List;

import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;

public class Survey {
	private User owner;
	private ArrayList<Question> questions;
	private int id;
	private Status status;
	private String name;
	private String description;
	
	public enum Status{
		ACTIVE,
		INACTIVE;
	}
	public Survey(User user) {
		this.owner=user;
		questions=new ArrayList<Question>();
		status=Status.ACTIVE;
	}
	private Survey() {
		
	}
	
	public void deactivate() {
		this.status=Status.INACTIVE;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Survey addQuestion(Question question) {
		questions.add(question);
		return this;
	}
	
	public Survey addQuestions(List<Question> questions) {
		questions.addAll(questions);
		return this;
	}
	
	public void removeQuestion(Question question) {
		questions.remove(question);
	}
	
	public void save() {
		
	}
}
