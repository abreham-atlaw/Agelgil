package com.agelgil.agelgil.lib.data.models.auth;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;


@Data
@Entity
@Table(name = "lib_auth_user")
public class User implements UserDetails{
	
	@Id
	private String username;

	private String password;

	private boolean enabled;

	private boolean tokenExpired;

	@Enumerated(EnumType.STRING)
	private Role role;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(
			new SimpleGrantedAuthority(getRole().toString())
		);
	}

	public static enum Role{
		ROLE_CLIENT,
		ROLE_HOTEL,
		ROLE_ADMIN
	}
	
}
