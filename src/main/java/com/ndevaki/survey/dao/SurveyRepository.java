package com.ndevaki.survey.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.Survey;
import com.ndevaki.survey.model.Survey.Status;
import com.ndevaki.survey.model.member.User;

@Component
public interface SurveyRepository extends CrudRepository<Survey,Integer> {
	public List<Survey> findByOwner(User user);
	public Survey findByIdAndStatus(int id, Status active);
}
