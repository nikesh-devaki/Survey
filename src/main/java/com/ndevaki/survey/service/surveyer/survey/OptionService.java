package com.ndevaki.survey.service.surveyer.survey;

import java.util.ArrayList;

import com.ndevaki.survey.model.choice.Option;

public class OptionService {

	public ArrayList<Option> getOptions(ArrayList<String> optionString) {
		ArrayList<Option> options=new ArrayList<Option>();
		optionString.forEach((str)->{
			options.add(new Option(str));
		});
		return options;
	}
}
