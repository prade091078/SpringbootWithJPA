package com.prade.JPA.SpringWithJPA.Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	//@Size(min=2,message = "Name should have atleast 2 characters")
    @Column(name = "description")
	@ApiModelProperty(notes = "Name should be atleast 2 characters")
	private String description;
	
	//@Past
    @JsonIgnore	
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
	public Post() {}

	public Post(Integer id, String description, User user) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
		
}
