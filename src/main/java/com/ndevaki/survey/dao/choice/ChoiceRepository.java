package com.ndevaki.survey.dao.choice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.choice.Choice;

@Component
public interface ChoiceRepository extends CrudRepository<Choice,Integer>{

}
