package com.agelgil.agelgil.client.di;

import java.security.Principal;

import com.agelgil.agelgil.client.data.models.Cart;
import com.agelgil.agelgil.client.data.models.Client;
import com.agelgil.agelgil.client.data.models.Cart.CartItem;
import com.agelgil.agelgil.client.data.repositories.CartItemRepository;
import com.agelgil.agelgil.client.data.repositories.CartRepository;
import com.agelgil.agelgil.client.data.repositories.ClientRepository;
import com.agelgil.agelgil.lib.data.repositories.auth.UserRepository;
import com.agelgil.agelgil.lib.extra.auth.UserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartManager {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemRepository cartItemRepository;


	public CartManager(){

	}

	public Cart getCart(String username){
		Client client = clientRepository.findByUser(
			userRepository.findByUsername(username)
			);
		if(client.getCart() == null)
			return createCart(client);
		
		return client.getCart();
		
	}

	public Cart getCart(Principal principal){
		return getCart(principal.getName());
	}

	private Cart createCart(Client client){
		Cart cart = new Cart();
		cart.setClient(client);
		cartRepository.save(cart);
		return cart;
	}

}
