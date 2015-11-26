package com.sumeru.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CAR")
public class Car extends BaseCarRentalObject {

	@Column(name = "carType", nullable = false)
	private String carType;

	@Column(name = "shortName"  ,nullable = false)//, unique=true, nullable = false)
	private String shortName;
	
	@Column(name = "capacity" ,nullable = false)
	private int capacity;
	
	@Column(name = "ratePerKm")
	private int ratePerKm;
	
	public Car() {
		super();
	}
	
	

	public Car(String carType, String shortName, int capacity, int ratePerKm) {
		super();
		this.carType = carType;
		this.shortName = shortName;
		this.capacity = capacity;
		this.ratePerKm = ratePerKm;
	}



	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(int ratePerKm) {
		this.ratePerKm = ratePerKm;
	}



	@Override
	public String toString() {
		return "Car [carType=" + carType + ", shortName=" + shortName
				+ ", capacity=" + capacity + ", ratePerKm=" + ratePerKm
				+ ", toString()=" + super.toString() + "]";
	}

	


	
	

}
