package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndevaki.survey.model.choice.Choice;
import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.dao.choice.ChoiceFactory;
import com.ndevaki.survey.dao.choice.ChoiceRepository;
import com.ndevaki.survey.dao.choice.OptionRepository;

@Service
public class ChoiceService {

	@Autowired
	OptionService optionService;
	ChoiceRepository choiceRepository;
	
	private void getChoiceRepository(ChoiceRepository choiceRepository) {
		this.choiceRepository=choiceRepository;
	}
	
	@Autowired
	public void getOptionService(OptionService optionService) {
		this.optionService=optionService;
	}
	
	public Choice createChoice(ArrayList<String> optionStrings,String type) throws Exception {
		ArrayList<Option> options=optionService.getOptions(optionStrings);
		ChoiceFactory choiceFactory=new ChoiceFactory();
		Choice choice=choiceFactory.getChoice(type, options);
		choiceRepository.save(choice);
		return choice;
	}
}
