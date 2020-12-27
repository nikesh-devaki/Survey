package com.ndevaki.survey.model.question;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.member.User;

public class Question {
	private String question;
	private String description;
	private Choice choice;
	private Type type;
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
	
	public void save() {
		
	}
	
}
