package com.ndevaki.survey.controller;

import java.net.URI;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.service.surveyer.survey.SurveyService;

@RestController
public class SurveyApiController {
	
	@Autowired
	SurveyService surveyService;
	
	@RequestMapping(path="/api/surveys/{surveyId}",method=RequestMethod.GET)
	public Survey getSurvey(@PathVariable int surveyId) {
		Survey survey=surveyService.getSurvey(surveyId);
		return survey;
	}
	
	@RequestMapping(path="/api/surveys",method=RequestMethod.GET)
	public Iterable<Survey> getAllSurveys() {
		return surveyService.getAllSurveys();
	}
	
	@RequestMapping(path="/api/surveys",method=RequestMethod.POST)
	public ResponseEntity createSurvey(@RequestBody Survey survey) {
		surveyService.createSurvey(survey);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(survey.getId()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@RequestMapping(path="/api/surveys/{surveyId}/questions",method=RequestMethod.POST)
	public void addQuestion(@PathVariable int surveyId,@RequestParam String questionString,
			@RequestParam String description,String QuestionType,String optionType,ArrayList<String> options) throws Exception {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.addQuestion(survey, questionString, description, options, QuestionType, optionType);
	}
	
	@RequestMapping(path="/api/surveys/{surveyId}/questions",method=RequestMethod.PUT)
	public void editSurvey(@PathVariable int surveyId,@RequestParam String name,@RequestParam String description) {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.editSurvey(survey, name, description);
	}
	
	@RequestMapping(path="/api/surveys/{surveyId}",method=RequestMethod.DELETE)
	public void deleteSurvey(@PathVariable int surveyId) {
		Survey survey=surveyService.getSurvey(surveyId);
		surveyService.deleteSurvey(survey);
	}

}
