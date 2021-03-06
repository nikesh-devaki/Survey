package com.ndevaki.survey.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;

@Entity
public class Survey {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne(targetEntity=User.class, fetch = FetchType.LAZY)
	private User owner;
	@Column
	private ArrayList<Question> questions;
	@Column
	private Status status;
	@Column
	private String name;
	@Column
	private String description;
	
	public enum Status{
		ACTIVE,
		IN_ACTIVE,
		IN_PROGRESS;
	}
	public Survey(User user) {
		this.owner=user;
		questions=new ArrayList<Question>();
		status=Status.ACTIVE;
	}
	private Survey() {
		
	}
	
	public int getId() {
		return id;
	}
	public User getOwner() {
		return owner;
	}
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	public void deactivate() {
		this.status=Status.IN_ACTIVE;
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
	
	public static Survey findByIdAndStatus(int id2, Status active) {
		// TODO Auto-generated method stub
		return null;
	}
}
