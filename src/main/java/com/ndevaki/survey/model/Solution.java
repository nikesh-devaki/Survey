package com.ndevaki.survey.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.model.question.Question;

@Entity
public abstract class Solution {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@Column
	Question question;
	@Column
	Option option;
	private Solution() {
		
	}
	public Solution(Question question, Option option) {
		super();
		this.question = question;
		this.option = option;
	}
	
	
}
