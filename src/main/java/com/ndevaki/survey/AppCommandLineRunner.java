package com.ndevaki.survey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ndevaki.survey.model.member.User;
import com.ndevaki.survey.dao.member.UserRepository;

@Component
public class AppCommandLineRunner implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User("nikesh","9940196586"));
		for(User user:userRepository.findAll()) {
			System.out.println(" user "+user.getName());
		}
	}

}
