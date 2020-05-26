package com.prade.JPA.SpringWithJPA.Entity;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;
import javax.persistence.OneToMany;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "All details about the user")
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	//@Size(min=2,message = "Name should have atleast 2 characters")
    @Column(name = "name")
	@ApiModelProperty(notes = "Name should be atleast 2 characters")
	private String name;
	
	//@Past
	@ApiModelProperty(notes = "Birthdate should be in the past")
    @Column(name = "birthdate")
	private Date birthdate;
	
	@OneToMany(mappedBy = "user") // name of the feild in post
	private List<Post> posts;
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User() {}
	
	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthdate=" + birthdate + "]";
	}
	
	
}
