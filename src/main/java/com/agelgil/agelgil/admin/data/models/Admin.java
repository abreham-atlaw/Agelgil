package com.agelgil.agelgil.admin.data.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.agelgil.agelgil.lib.data.models.auth.User;
import com.agelgil.agelgil.lib.data.models.auth.UserType;

import lombok.Data;


@Data
@Entity
@Table(
	name = "admin_admin",
	uniqueConstraints = @UniqueConstraint(columnNames = {"user_username"})
	)
public class Admin extends UserType{
	
	@Id
	private Long id;

	@ManyToOne
	private User user;
	
	private String firstName;
	private String lastName;

	
}
