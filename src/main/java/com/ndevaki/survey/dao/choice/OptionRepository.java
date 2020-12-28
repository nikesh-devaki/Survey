package com.ndevaki.survey.dao.choice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.choice.Option;

@Component
public interface OptionRepository  extends CrudRepository<Option, Integer>  {

}
