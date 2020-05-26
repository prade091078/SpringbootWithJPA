package com.prade.JPA.SpringWithJPA.Entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.validation.constraints.Past;
//import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "All details about the user")
@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;
	
	//@Past
	@ApiModelProperty(notes = "Birthdate should be in the past")
    @Column(name = "birthdate")
	private Date birthdate;
	
	//@Size(min=2,message = "Name should have atleast 2 characters")
    @Column(name = "name")
	@ApiModelProperty(notes = "Name should be atleast 2 characters")
	private String name;
	
	
	public Employee() {}
	
	public Employee(Integer id, Date birthdate, String name) {
		super();
		this.id = id;
		this.birthdate = birthdate;
		this.name = name;
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
		return "Employee [id=" + id + ", birthdate=" + birthdate + ", name=" + name + "]";
	}

	
	
}
