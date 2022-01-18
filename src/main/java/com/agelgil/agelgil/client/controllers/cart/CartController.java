package com.agelgil.agelgil.client.controllers.cart;

import java.security.Principal;

import javax.validation.Valid;

import com.agelgil.agelgil.client.controllers.cart.forms.AddToCartForm;
import com.agelgil.agelgil.client.data.models.Cart;
import com.agelgil.agelgil.client.data.repositories.CartItemRepository;
import com.agelgil.agelgil.client.di.CartManager;
import com.agelgil.agelgil.lib.exceptions.httperror.InternalServerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CartController {

	@Autowired
	private CartManager cartManager;

	@Autowired
	private CartItemRepository cartItemRepository;

	@PostMapping("/client/cart/add")
	public String addToCart(
		@Valid AddToCartForm addToCartForm,
		BindingResult bindingResult,
		Principal principal,
		@RequestParam(name = "redirect_url") String redirectUrl
		){

		if(bindingResult.hasErrors())
			throw new InternalServerException();
		
		addToCartForm.setCart(cartManager.getCart(principal));
		addToCartForm.setCartItemRepository(cartItemRepository);

		addToCartForm.addToCart();

		return String.format("redirect:%s", redirectUrl);

	}

}
