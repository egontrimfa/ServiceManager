package com.license.Szerviz.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Registration")
@Table(name="registrations", catalog="postgres", schema="public")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="regnr")
	private String regnr;
	
	@Column(name="regdate")
	private Date regdate;
	
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @ManyToOne
    @JoinColumn(name="carsid", insertable = false, updatable = false)
    private Car cars;

    @OneToMany(mappedBy="registrations")
    private Set<Registrations_inventory> registrations_inventory;
    
    @OneToMany(mappedBy="registrations")
    private Set<Job_registration> job_registration;
    
    @OneToOne(mappedBy = "registrations")
    private Invoice invoice;
    
	public Registration() {
	}
	
	public Registration(int id, String regnr, Date regdate, Client clients, Car cars) {
		this.id = id;
		this.regnr = regnr;
		this.regdate = regdate;
		this.clients = clients;
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public Car getCars() {
		return cars;
	}

	public void setCars(Car cars) {
		this.cars = cars;
	}

	public Set<Registrations_inventory> getRegistrations_inventory() {
		return registrations_inventory;
	}

	public void setRegistrations_inventory(Set<Registrations_inventory> registrations_inventory) {
		this.registrations_inventory = registrations_inventory;
	}

	public Set<Job_registration> getJob_registration() {
		return job_registration;
	}

	public void setJob_registration(Set<Job_registration> job_registration) {
		this.job_registration = job_registration;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", regnr=" + regnr + ", regdate=" + regdate + ", client=" + clients + ", car="
				+ cars + "]";
	}
}
