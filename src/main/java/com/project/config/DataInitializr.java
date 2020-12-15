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
		
//		User user = new User("gabriel3", "gab3@gab.com");
//		Message message = new Message("third message", user);
//		user.appendMessage(message);
		User user = userRepository.findByName("gabriel3");
		List<Role> roles = new ArrayList<Role>();
		roles.add(new Role("Admin"));
		roles.add(new Role("User"));
		user.setRoles(roles);
		userRepository.save(user);
		user = userRepository.findByName("gabriel");
		roles.set(1, new Role("Admin"));
		user.setRoles(roles);
		userRepository.save(user);
//		List<Message> messages = messageRepository.findAll();
//		
//		for(Message message2 : messages) {
//			System.out.println(message2.getSourceUser().getName() + ": " + message2.getText());
//		}
		
		User user2 = userRepository.findByName("gabriel3");
		System.out.println("roles de " + user2.getName());
		for(Role role : user2.getRoles()) {
			System.out.println(role.getName());
		}
		
		List<Role> roles2 = roleRepository.findAll();
		for(Role role2 : roles2) {
			System.out.println("users da role " + " " + role2.getId() + role2.getName());
			for(User user3: role2.getUsers()) {
				System.out.println(user3.getName());
			}
		}
	}


}
