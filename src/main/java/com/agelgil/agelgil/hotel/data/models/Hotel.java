package com.agelgil.agelgil.hotel.data.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.agelgil.agelgil.lib.data.models.auth.User;
import com.agelgil.agelgil.lib.data.models.auth.UserType;

import lombok.Data;


@Data
@Entity
@Table(
	name = "hotel_hotel",
	uniqueConstraints = @UniqueConstraint(columnNames = {"user_username"})
	)
public class Hotel extends UserType {
	

	@Id
	private Long id;

	@ManyToOne
	private User user;

	private String name;

	@Embedded
	private Location location;

	private Integer standard;

	private String legalDocument;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "hotel")
	private List<Service> services;


	@Data
	@Embeddable
	public static class Location{

		private Double latitude;

		private Double longitude;

	} 
}
