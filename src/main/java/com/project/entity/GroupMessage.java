package com.project.entity;
import javax.persistence.*;

@Entity
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String text;
	
	@ManyToOne
	private User sourceUser;

	public Long getId() {
		return id;
	}

	public GroupMessage() {
	}

	public GroupMessage(String text, User sourceUser) {
		this.text = text;
		this.sourceUser = sourceUser;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getSourceUser() {
		return sourceUser;
	}

	public void setSourceUser(User sourceUser) {
		this.sourceUser = sourceUser;
	}
	
	
}
