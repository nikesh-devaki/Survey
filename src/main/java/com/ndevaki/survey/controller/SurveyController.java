package com.ndevaki.survey.controller;

import java.net.URI;
import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.question.Question;
import com.ndevaki.survey.service.surveyer.survey.ChoiceService;
import com.ndevaki.survey.service.surveyer.survey.QuestionService;
import com.ndevaki.survey.service.surveyer.survey.SurveyService;

@RestController
public class SurveyController {
	
	@Autowired
	SurveyService surveyService;
	
	@RequestMapping(path="/surveys/{surveyId}",method=RequestMethod.GET)
	public Survey getSurvey(@PathVariable int surveyId) {
		Survey survey=surveyService.getSurvey(surveyId);
		return survey;
	}
	
	@RequestMapping(path="/surveys",method=RequestMethod.GET)
	public Iterable<Survey> getAllSurveys() {
		System.out.println("Getting all surveys");
		return surveyService.getAllSurveys();
	}
	
	@RequestMapping(path="/surveys",method=RequestMethod.POST,produces = "application/json")
	public ResponseEntity createSurvey(@RequestBody Survey survey) {
		surveyService.createSurvey(survey);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(survey.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@RequestMapping(path="/surveys/{surveyId}/questions",method=RequestMethod.POST)
	public void addQuestion(@PathVariable int surveyId,@RequestParam String questionString,
			@RequestParam String description,String QuestionType,String optionType,ArrayList<String> options) throws Exception {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.addQuestion(survey, questionString, description, options, QuestionType, optionType);
	}
	
	@RequestMapping(path="/surveys/{surveyId}/questions",method=RequestMethod.PUT)
	public void editSurvey(@PathVariable int surveyId,@RequestParam String name,@RequestParam String description) {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.editSurvey(survey, name, description);
	}
	
	@RequestMapping(path="/surveys/{surveyId}",method=RequestMethod.DELETE)
	public void deleteSurvey(@PathVariable int surveyId) {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.deleteSurvey(survey);
	}

}
