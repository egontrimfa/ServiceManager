package com.license.Szerviz.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Brand")
@Table(name="brands", catalog="postgres", schema="public")
public class Brand {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="brandname")
	private String brandname;
	
    @OneToMany(mappedBy="brands")
    private Set<Model> models;
    
    @OneToOne(mappedBy = "brands")
    private Car cars;

	public Brand() {
	}

	public Brand(Integer id, String brandname) {
		this.id = id;
		this.brandname = brandname;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	
	public Set<Model> getModels() {
		return models;
	}

	public void setModels(Set<Model> models) {
		this.models = models;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return brandname.toUpperCase();
	}
}
