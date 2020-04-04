package com.license.Szerviz.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name = "cars", catalog = "postgres", schema = "public")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "licensenumber")
	private String licenseNumber;

	@Column(name = "chassisnr", unique = true)
	private String chassisnr;
	
	@Column(name = "enginenr")
	private String enginenr;
	
	@Column(name = "milometer")
	private int milometer;
	
    @OneToMany(mappedBy="cars")
    private Set<Registration> registrations;
	
	public Car() {
	}

	public Car(String licenseNumber, String brand, String model, String chassisnr, String enginenr, int milometer) {
		this.licenseNumber = licenseNumber;
		this.brand = brand;
		this.model = model;
		this.chassisnr = chassisnr;
		this.enginenr = enginenr;
		this.milometer = milometer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getChassisnr() {
		return chassisnr;
	}

	public void setChassisnr(String chassisnr) {
		this.chassisnr = chassisnr;
	}

	public String getEnginenr() {
		return enginenr;
	}

	public void setEnginenr(String enginenr) {
		this.enginenr = enginenr;
	}

	public int getMilometer() {
		return milometer;
	}

	public void setMilometer(int milometer) {
		this.milometer = milometer;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", licenseNumber=" + licenseNumber
				+ ", chassisnr=" + chassisnr + ", enginenr=" + enginenr + ", milometer=" + milometer + "]";
	}

}
