package com.agelgil.agelgil.hotel.data.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.tools.DocumentationTool.Location;

import com.agelgil.agelgil.lib.data.models.auth.UserType;

import lombok.Data;


@Data
@Entity
@Table(name = "hotel_hotel")
public class Hotel extends UserType {
	
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
