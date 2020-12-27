package com.ndevaki.survey.model.question;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.member.User;

public abstract class Question {
	private String question;
	private String description;
	private Choice choice;
	private Type type;
	
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
	
}
