package com.ndevaki.survey.model.choice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "choice")
public abstract class Choice {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@OneToMany(targetEntity=Option.class,mappedBy="choice", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	Set<Option> options;
	
	private Choice() {
		
	}
	public Choice(Set<Option> options) {
		this.options=options;
	}
	
	public Choice addOption(Option option) {
		this.options.add(option);
		return this;
	}
	
	public void addOptions(Set<Option> options) {
		this.options=options;
	}
}
