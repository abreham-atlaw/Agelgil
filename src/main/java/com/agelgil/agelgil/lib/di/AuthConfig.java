package com.agelgil.agelgil.lib.di;

import java.util.Arrays;
import java.util.List;

import com.agelgil.agelgil.lib.controllers.auth.handlers.AgelgilAuthenticationSuccessHandler;
import com.agelgil.agelgil.lib.data.models.auth.User;
import com.agelgil.agelgil.lib.data.repositories.auth.UserRepository;
import com.agelgil.agelgil.lib.extra.auth.UserManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;



@Configuration
@EnableWebSecurity
public class AuthConfig{

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository){
		
		return new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userRepository.findByUsername(username);
				if(user == null)
					throw new UsernameNotFoundException(
						String.format("User with username %s not found", username)
					);
				return user;
			}

		};
	}


	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(
		HttpSecurity httpSecurity,
		@Qualifier("clientOnlyPatterns") List<String> clientOnlyPattens,
		@Qualifier("hotelOnlyPatterns") List<String> hotelOnlyPatterns,
		@Qualifier("adminOnlyPatterns") List<String> adminOnlyPatterns
	) throws Exception{

		return httpSecurity
							.authorizeRequests()
							.antMatchers(clientOnlyPattens.toArray(new String[0])).hasRole(User.Role.CLIENT.name())
							.antMatchers(hotelOnlyPatterns.toArray(new String[0])).hasRole(User.Role.HOTEL.name())
							.antMatchers(adminOnlyPatterns.toArray(new String[0])).hasRole(User.Role.ADMIN.name())
							.antMatchers("/", "/**").permitAll()
							.and()
							.formLogin()
							.loginPage("/login")
							.successHandler(authenticationSuccessHandler())
							.and()
							.build();

	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler(){
		return new AgelgilAuthenticationSuccessHandler();
	}

	@Bean 
	public List<String> hotelOnlyPatterns(){
		return Arrays.asList(
			"/hotel/dashboard/**"
		);
	}

	@Bean 
	public List<String> adminOnlyPatterns(){
		return Arrays.asList(
			"/admin/dashboard/**"
		);
	}

	@Bean 
	public List<String> clientOnlyPatterns(){
		return Arrays.asList(
			"/client/cart/**"
		);
	}
	
	@Bean
	public UserManager userManager(UserRepository repository, PasswordEncoder encoder){
		return new UserManager(repository, encoder);
	}


}
