package com.agelgil.agelgil.lib.data.models.auth;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
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

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // TODO
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // TODO
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // TODO: 
	}

	public static enum Role{
		CLIENT,
		HOTEL,
		ADMIN
	}
	
}
