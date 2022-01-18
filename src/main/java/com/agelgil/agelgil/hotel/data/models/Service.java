package com.agelgil.agelgil.hotel.data.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import groovyjarjarantlr4.v4.runtime.ANTLRErrorListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "hotel_service")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String coverImage;

	private Float unitPrice;

	private Integer availableUnits;

	@ManyToOne
	private ServiceType serviceType;

	@ManyToOne
	private Hotel hotel;


	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	@Entity
	@Table(
		name = "hotel_service_type",
		uniqueConstraints = @UniqueConstraint(columnNames =  {"name"})
		)
	public static class ServiceType{

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private Integer id;
		
		private String name;

		@Enumerated(EnumType.STRING)
		private Unit unit;
	
		private static enum Unit{
			NIGHT, DAY, MONTH, WEEK
		}

	}
	
}
