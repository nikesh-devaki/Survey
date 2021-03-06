package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ndevaki.survey.dao.SurveyRepository;
import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;
import com.ndevaki.survey.dao.question.QuestionBuilder;

@Service
public class SurveyService {
	
	
	private QuestionService questionService;
	private ChoiceService choiceService;
	private SurveyRepository surveyRepository;
    
	@Autowired
	private void getQuestionService(QuestionService questionService) {
		this.questionService=questionService;
	}
	
	@Autowired
	private void getChoiceService(ChoiceService choiceService) {
		this.choiceService=choiceService;
	}
	
	@Autowired
	private void getSurveyRepository(SurveyRepository repository) {
		this.surveyRepository=repository;
	}
	
	public Iterable<Survey> getAllSurveys(){
		return surveyRepository.findAll();
	}
	
	public Survey getSurvey(int id) {
		Survey survey=surveyRepository.findByIdAndStatus(id,Survey.Status.ACTIVE);
		return survey;
	}
	//Create Survey
	public Survey createSurvey(Survey survey) {
		User user=null; //current logged in user
		survey.setStatus(Survey.Status.IN_PROGRESS);
		surveyRepository.save(survey);
		return survey;
	}
	
	//adds question to survey
	public void addQuestion(Survey survey,String questionStr,String description,ArrayList<String> options,
			String QuestionType,String OptionsType) throws Exception {
		
		Choice choice=choiceService.createChoice(options, OptionsType);
		Question question=questionService.createQuestion(questionStr,description,choice,QuestionType);
		survey.addQuestion(question);
		surveyRepository.save(survey);
	}
	
    //Edit Survey
	public void editSurvey(Survey survey,String name,String description) {
		survey.setName(name);
		survey.setDescription(description);
		surveyRepository.save(survey);
	}
	
	//Delete Survey
	public void deleteSurvey(Survey survey) {
		survey.setStatus(Survey.Status.IN_ACTIVE);
		surveyRepository.save(survey);
	}
	
    //View Survey
	public Survey viewSurvey() {
		return null;
	}
	
	public List<Survey> surveyList(User user){
		return surveyRepository.findByOwner(user);
	}
	
	//	View Survey Report
}
