package com.ndevaki.survey.dao.question;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.question.Question;

public class QuestionBuilder {

	private Question question;
	
	public QuestionBuilder createQuestion() {
		question=new Question();
		question.setStatus(Question.Status.ACTIVE);
		return this;
	}
	
	public QuestionBuilder addQuestion(String str) {
		question.setQuestion(str);
		return this;
	}
	
	public QuestionBuilder addDescription(String str) {
		question.setDescription(str);
		return this;
	}
	
	public QuestionBuilder addChoice(Choice choice) {
		question.setChoice(choice);
		return this;
	}
	
	public QuestionBuilder addType(Question.Type type) {
		question.setType(type);
		return this;
	}
	
	public Question build() throws Exception {
		if(this.question!=null&&this.question.validate()) {
			return this.question;
		}else {
			throw new Exception("Question object data insufficent");
		}
	}
}
