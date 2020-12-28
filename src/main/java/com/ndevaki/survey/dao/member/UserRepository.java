package com.ndevaki.survey.dao.member;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.member.User;

@Component
public interface UserRepository extends CrudRepository<User,Integer> {

}
