package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.choice.ChoiceFactory;
import com.ndevaki.survey.model.choice.Option;

public class ChoiceService {

	@Autowired
	OptionService optionService;
	ChoiceService choiceService;
	public Choice createChoice(ArrayList<String> optionStrings,String type) throws Exception {
		ArrayList<Option> options=optionService.getOptions(optionStrings);
		ChoiceFactory choiceFactory=new ChoiceFactory();
		Choice choice=choiceFactory.getChoice(type, options);
		return choice;
	}
}
