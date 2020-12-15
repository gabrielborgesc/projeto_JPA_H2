package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
		
	User findByName(String name);
	
	List<User> findByNameContainingOrderByIdDesc(String name);

	User findByEmail(String string);
	
	@Query("select u from User u where u.id>=?1 and u.name like %?2%")
	List<User> findIdBiggerThan(Long id, String LikeName);
	
}
