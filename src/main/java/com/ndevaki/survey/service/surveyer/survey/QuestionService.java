package com.ndevaki.survey.service.surveyer.survey;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.question.Question;
import com.ndevaki.survey.model.question.QuestionBuilder;

public class QuestionService {

//	 Question:
//	   -Create Question
	public Question createQuestion(String name,String description,Choice choice,String type) throws Exception {
		QuestionBuilder builder=new QuestionBuilder();
		Question question=builder.addQuestion(name).addDescription(description)
				.addType(Question.Type.valueOf(type)).addChoice(choice).build();
		question.save();
		return question;
	}
//	   -Edit Question
	public void editQuestion() {
		
	}
//	   -Delete Question
	public void deleteQuestion(Question question) {
		if(question!=null) {
			question.setStatus(Question.Status.INACTIVE);
		}
	}
//	 Choice:
//	    -Add Choice
	private Choice addChoice() {
		return null;
	}
//	    -Add answer 
}
