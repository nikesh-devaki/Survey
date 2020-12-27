package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;

public class SurveyService {
//	 -- Create Survey
	public void createSurvey(ArrayList<Question> questions) {
		User user=null; //current logged in user
		Survey survey=new Survey(user);
		survey.addQuestions(questions);
		survey.save();
	}
//	 -- Edit Survey
	public void editSurvey(Survey survey,String name,String description) {
		survey.setName(name);
		survey.setDescription(description);
	}
	
//	 -- Delete Survey
	public void deleteSurvey(Survey survey) {
		survey.deactivate();
	}
//	 -- View Survey
	public Survey viewSurvey() {
		return null;
	}
//	 -- View Survey Report
}
