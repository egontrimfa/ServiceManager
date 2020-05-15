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
	private Integer id;
	
	@Column(name="clientsid")
	private Integer clientsid;
	
	@Column(name="carsid")
	private Integer carsid;
	
	@Column(name="regnr")
	private String regnr;
	
	@Column(name="regdate")
	private Date regdate;
	
	@Column(name="registrationcomment")
	private String registrationcomment;
	
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @ManyToOne
    @JoinColumn(name="carsid", insertable = false, updatable = false)
    private Car cars;

    @OneToMany(mappedBy="registrations")
    private Set<Registrations_inventory> registrations_inventory;
    
    @OneToMany(mappedBy="registrations")
    private Set<Registration_job> job_registration;
    
    @OneToOne(mappedBy = "registrations")
    private Invoice invoice;
    
	public Registration() {
	}

	public Registration(String regnr, Date regdate) {
		this.regnr = regnr;
		this.regdate = regdate;
	}

	public Registration(String regnr, Date regdate, String registrationcomment) {
		this.regnr = regnr;
		this.regdate = regdate;
		this.registrationcomment = registrationcomment;
	}

	public Registration(Integer clientsid, String regnr, Date regdate) {
		this.clientsid = clientsid;
		this.regnr = regnr;
		this.regdate = regdate;
	}

	public Registration(Integer clientsid, Integer carsid, String regnr, Date regdate) {
		this.clientsid = clientsid;
		this.carsid = carsid;
		this.regnr = regnr;
		this.regdate = regdate;
	}
	
	public Registration(Integer clientsid, Integer carsid, String regnr, Date regdate, String registrationcomment) {
		this.clientsid = clientsid;
		this.carsid = carsid;
		this.regnr = regnr;
		this.regdate = regdate;
		this.registrationcomment = registrationcomment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarsid() {
		return carsid;
	}

	public void setCarsid(Integer carsid) {
		this.carsid = carsid;
	}

	public Integer getClientsid() {
		return clientsid;
	}

	public void setClientsid(Integer clientsid) {
		this.clientsid = clientsid;
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
	
	public String getRegistrationcomment() {
		return registrationcomment;
	}

	public void setRegistrationcomment(String registrationcomment) {
		this.registrationcomment = registrationcomment;
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

	public Set<Registration_job> getJob_registration() {
		return job_registration;
	}

	public void setJob_registration(Set<Registration_job> job_registration) {
		this.job_registration = job_registration;
	}

	public Invoice getInvoice() {
		return invoice;
	}
	
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", clientsid=" + clientsid + ", carsid=" + carsid + ", regnr=" + regnr
				+ ", regdate=" + regdate + ", registrationcomment=" + registrationcomment + "]";
	}
}
