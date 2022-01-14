package com.agelgil.agelgil.lib.data.models.auth;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Entity
@Table(name = "lib_auth_client")
public class Client extends UserType{
	
	private String firstName;
	private String lastName;

}
