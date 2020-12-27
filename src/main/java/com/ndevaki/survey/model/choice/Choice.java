package com.ndevaki.survey.model.choice;

import java.util.ArrayList;

public abstract class Choice {

	ArrayList<Option> options;
	
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
