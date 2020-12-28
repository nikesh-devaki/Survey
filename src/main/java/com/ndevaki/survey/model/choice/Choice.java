package com.ndevaki.survey.model.choice;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public abstract class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	ArrayList<Option> options;
	
	private Choice() {
		
	}
	public Choice(ArrayList<Option> options) {
		this.options=options;
	}
	
	public Choice addOption(Option option) {
		this.options.add(option);
		return this;
	}
	
	public void addOptions(ArrayList<Option> options) {
		this.options=options;
	}
}
