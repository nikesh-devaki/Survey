package com.ndevaki.survey.dao.question;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.question.Question;

@Component
public interface QuestionRepository extends CrudRepository<Question,Integer> {

}
