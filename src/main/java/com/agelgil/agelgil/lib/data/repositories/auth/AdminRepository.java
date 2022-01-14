package com.agelgil.agelgil.lib.data.repositories.auth;

import com.agelgil.agelgil.lib.data.models.auth.Admin;

import org.springframework.data.repository.CrudRepository;


public interface AdminRepository extends CrudRepository<Admin, String>{
	
}
