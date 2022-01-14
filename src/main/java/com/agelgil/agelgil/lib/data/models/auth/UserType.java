package com.agelgil.agelgil.lib.data.models.auth;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
public class UserType {
	
	@Id
	@OneToOne(mappedBy = "username")
	protected User user;

}
