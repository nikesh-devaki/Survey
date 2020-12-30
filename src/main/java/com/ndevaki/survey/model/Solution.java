package com.ndevaki.survey.model;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.model.question.Question;

@Entity
public abstract class Solution {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	@OneToOne(targetEntity=Question.class, fetch = FetchType.LAZY)
	Question question;
	@ManyToOne(targetEntity=Option.class, fetch = FetchType.LAZY)
	Option option;
	private Solution() {
		
	}
	public Solution(Question question, Option option) {
		super();
		this.question = question;
		this.option = option;
	}
	
	
}
