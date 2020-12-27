package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;
import com.ndevaki.survey.model.question.QuestionBuilder;

public class SurveyService {
	
	QuestionService questionService;
	ChoiceService choiceService;
    
	//Create Survey
	public Survey createSurvey(ArrayList<Question> questions) {
		User user=null; //current logged in user
		Survey survey=new Survey(user);
		survey.addQuestions(questions);
		survey.save();
		return survey;
	}
	
	//adds question to survey
	public void addQuestion(Survey survey,String questionStr,String description,ArrayList<String> options,
			String QuestionType,String OptionsType) throws Exception {
		
		Choice choice=choiceService.createChoice(options, OptionsType);
		Question question=questionService.createQuestion(questionStr,description,choice,QuestionType);
		survey.addQuestion(question);
		survey.save();
	}
	
    //Edit Survey
	public void editSurvey(Survey survey,String name,String description) {
		survey.setName(name);
		survey.setDescription(description);
	}
	
	//Delete Survey
	public void deleteSurvey(Survey survey) {
		survey.deactivate();
	}
	
    //View Survey
	public Survey viewSurvey() {
		return null;
	}
	
	//	View Survey Report
}
