package com.springboot.storage.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tank_location")
public class TankLocation {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loc_id;
	private String location;
	
	
	
	
}


