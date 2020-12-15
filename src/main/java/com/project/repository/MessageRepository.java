package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.entity.Message;
import com.project.entity.User;


public interface MessageRepository extends JpaRepository<Message, Long> {
	
	List<Message> findBySourceUser(User user);
	
	
}
