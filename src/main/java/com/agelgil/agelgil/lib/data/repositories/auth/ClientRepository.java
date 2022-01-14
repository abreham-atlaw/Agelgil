package com.agelgil.agelgil.lib.data.repositories.auth;

import com.agelgil.agelgil.lib.data.models.auth.Client;

import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, String>{
	
}
