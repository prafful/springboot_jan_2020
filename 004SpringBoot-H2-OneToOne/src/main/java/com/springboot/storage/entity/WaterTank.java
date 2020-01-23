package com.springboot.storage.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "water_tank")
public class WaterTank {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "tank_capacity")
	private String capacity;
	@Column(name = "tank_type")
	private String tankType;
	@Column(name = "tank_status")
	private String status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private TankDetail tankDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getTankType() {
		return tankType;
	}

	public void setTankType(String tankType) {
		this.tankType = tankType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public TankDetail getTankDetail() {
		return tankDetail;
	}

	public void setTankDetail(TankDetail tankDetail) {
		this.tankDetail = tankDetail;
	}

	public WaterTank(Integer id, String capacity, String tankType, String status, TankDetail tankDetail) {
		super();
		this.id = id;
		this.capacity = capacity;
		this.tankType = tankType;
		this.status = status;
		this.tankDetail = tankDetail;
	}

	public WaterTank() {
		super();
	}

	

	
	
	
	
	
}
