package com.ndevaki.survey.model.question;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.member.User;

@Entity
public class Question {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String question;
	@Column
	private String description;
	@OneToOne(targetEntity=Choice.class, fetch = FetchType.LAZY)
	private Choice choice;
	@Column
	private Type type;
	@Column
	private Status status;
	
	public enum Status{
		ACTIVE,
		INACTIVE;
	}
	
	public enum Type{
		MANDITORY("Manditory"),
		OPTIONAL("Optional");
		
		String displayName;
		
		Type(String displayName) {
			this.displayName=displayName;
		}
		
		public String getDisplayName() {
			return this.displayName;
		}
		
	}
	private Question() {}
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public boolean validate() {
		return (this.status!=null&&this.choice!=null&&this.question!=null&&
				this.type!=null);
	}
	
}
