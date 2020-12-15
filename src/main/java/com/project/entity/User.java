package com.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.transaction.annotation.Transactional;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	
//	@ManyToMany(cascade=CascadeType.ALL)
//	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany
	@JoinTable(name = "user_roles",
			joinColumns = @JoinColumn(name = "users_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id"))
	@Cascade(CascadeType.MERGE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roles; //Para salvar novo user com nova role, precisa dar save só no user, adicionar a role e dar outro save
	
	public Long getId() {
		return id;
	}
	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}
	public User() {
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if(this.roles == null) {
			this.roles = new ArrayList<Role>();
		}
		this.roles.add(role);
	}
}
