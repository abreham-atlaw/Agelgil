package com.agelgil.agelgil.lib.data.models.auth;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "lib_auth_admin")
public class Admin extends UserType{
	
	private String firstName;
	private String lastName;


}
