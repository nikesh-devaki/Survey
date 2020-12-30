package com.ndevaki.survey.model.choice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Option {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String message;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Choice choice;
	
	private Option() {}
	
	public Option(String msg) {
		this.message=msg;
	}
}
