package com.ndevaki.survey.model.choice;

import java.util.ArrayList;

public class ChoiceFactory {

	public enum Type{
		SINGLE("Single"),
		MULTI("Multi");
		String label;
		Type(String s){
			this.label=s;
		}
	}
	
	public Choice getChoice(String choice,ArrayList<Option> options) throws Exception {
		Choice c;
		switch(choice) {
			case "Single":
				c= new SingleChoice(options);
				break;
			case "Multi":
				c=new MultiChoice(options);
				break;
			default:
				throw new Exception("Invalid choice type provided");	
		}
		return c;
	}
}
