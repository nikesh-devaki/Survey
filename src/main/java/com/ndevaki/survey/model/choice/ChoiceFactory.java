package com.ndevaki.survey.model.choice;

public class ChoiceFactory {

	public enum Type{
		SINGLE("Single"),
		MULTI("Multi");
		String label;
		Type(String s){
			this.label=s;
		}
	}
	
	public Choice getChoice(String choice) throws Exception {
		Choice c;
		switch(choice) {
			case "Single":
				c= new SingleChoice();
				break;
			case "Multi":
				c=new MultiChoice();
				break;
			default:
				throw new Exception("Invlid choice type provided");	
		}
		return c;
	}
}
