package com.ndevaki.survey.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.Solution;
import com.ndevaki.survey.model.Survey;

@Component
public interface SolutionRepository extends CrudRepository<Solution,Integer>{
	
}
