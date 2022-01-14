package com.agelgil.agelgil.lib.di;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import java.security.Principal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
import org.thymeleaf.spring5.SpringTemplateEngine;


@Configuration
public class Configs {

	@Bean
	public LayoutDialect layoutDialect(){
		return new LayoutDialect();
	}
}
