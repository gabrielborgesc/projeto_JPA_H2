package com.project.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.project.entity.Message;
import com.project.entity.Role;
import com.project.entity.User;
import com.project.repository.MessageRepository;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;

@Component
public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		User user = userRepository.findByName("borges");
		Role role = roleRepository.findByName("SuperUser");
		user.addRole(role);
		userRepository.save(user);

	}
}
