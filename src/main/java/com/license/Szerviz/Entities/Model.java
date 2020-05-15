package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Model")
@Table(name="models", catalog="postgres", schema="public")
public class Model {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="brandsid")
	private Integer brandsid;
	
	@Column(name="modelname")
	private String modelname;
	
    @ManyToOne
    @JoinColumn(name="brandsid", insertable = false, updatable = false)
    private Brand brands;
    
    @OneToOne(mappedBy = "models")
    private Car cars;
    
	public Model() {
	}

	public Model(Integer id, Integer brandsid, String modelname) {
		this.id = id;
		this.brandsid = brandsid;
		this.modelname = modelname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrandsid() {
		return brandsid;
	}

	public void setBrandsid(Integer brandsid) {
		this.brandsid = brandsid;
	}

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	
	public Brand getBrands() {
		return brands;
	}

	public void setBrands(Brand brands) {
		this.brands = brands;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	@Override	
	public String toString() {
		return modelname.toUpperCase();
	}
}
