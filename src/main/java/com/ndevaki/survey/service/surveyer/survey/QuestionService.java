package com.ndevaki.survey.service.surveyer.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndevaki.survey.dao.question.QuestionRepository;
import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.question.Question;
import com.ndevaki.survey.dao.question.QuestionBuilder;

@Service
public class QuestionService {

	QuestionRepository questionRepository;
	
	@Autowired
	private void getQuestionRepository(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}

    //Creates new Question
	public Question createQuestion(String name,String description,Choice choice,String type) throws Exception {
		QuestionBuilder builder=new QuestionBuilder();
		Question question=builder.addQuestion(name).addDescription(description)
				.addType(Question.Type.valueOf(type)).addChoice(choice).build();
		questionRepository.save(question);
		return question;
	}
	//Edits Question
	public void editQuestion() {
		
	}
    //Delete Question
	public void deleteQuestion(Question question) {
		if(question!=null) {
			question.setStatus(Question.Status.INACTIVE);
			questionRepository.save(question);
		}
	}
	//Adds Choice
	private Choice addChoice() {
		return null;
	}
    //Add answer 
}
