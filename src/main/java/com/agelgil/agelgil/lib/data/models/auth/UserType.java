package com.agelgil.agelgil.lib.data.models.auth;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;


@Data
public abstract class UserType {
	
	public abstract User getUser();

	
}
