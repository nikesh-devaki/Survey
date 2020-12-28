package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.dao.choice.OptionRepository;

@Service
public class OptionService {
	
	OptionRepository optionRepository;
	
	@Autowired
	private void getOptionRepository(OptionRepository optionRepository) {
		this.optionRepository=optionRepository;
	}
	
	public ArrayList<Option> getOptions(ArrayList<String> optionString) {
		ArrayList<Option> options=new ArrayList<Option>();
		optionString.forEach((str)->{
			Option option=new Option(str);
			optionRepository.save(option);
			options.add(option);
		});
		return options;
	}
}
