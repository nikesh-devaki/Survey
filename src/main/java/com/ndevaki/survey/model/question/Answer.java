package com.ndevaki.survey.model.question;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.ndevaki.survey.model.Solution;
import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.choice.Option;
import com.ndevaki.survey.model.member.User;

@Entity
public abstract class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToOne(targetEntity=User.class, fetch = FetchType.LAZY)
	private User user;
	@OneToOne(targetEntity=Survey.class, fetch = FetchType.LAZY)
	private Survey survey;
	@OneToOne(targetEntity=Option.class, fetch = FetchType.LAZY)
	private Option option;
	
	private Answer() {}
}
