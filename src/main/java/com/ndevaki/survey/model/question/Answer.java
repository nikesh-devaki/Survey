package com.ndevaki.survey.model.question;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.ndevaki.survey.model.Solution;
import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.member.User;

@Entity
public abstract class Answer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column
	private Solution solution;
	@Column
	private User user;
	@Column
	private Survey survey;
	
	private Answer() {}
}
