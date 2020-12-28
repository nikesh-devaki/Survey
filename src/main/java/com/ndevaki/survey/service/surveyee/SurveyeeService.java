package com.ndevaki.survey.service.surveyee;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Answer;
import com.ndevaki.survey.model.question.Question;

@Service
public class SurveyeeService {


	
	//Submit Survey
	public void submit(int surveyId,Map<Question,Option> input,User user) throws Exception {
		if(userSurveyStatus(user,surveyId)) {
			throw new Exception("Survey already taken");
		}
		answerService.collect(surveyId,input,user);
	}
	//Survey Status
	public boolean userSurveyStatus(User user,int surveyId) {
		List<Object> resultSet=Answer.findBySurveyAndUser(surveyId, user);
		return resultSet.size()>0;
	}
	
}
