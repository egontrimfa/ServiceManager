package com.license.Szerviz.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Client")
@Table(name="clients", catalog="postgres", schema="public")
public class Client implements Serializable {
	
	private static final long serialVersionUID = -8287008052312352231L;

	//clients table's columns implementation to variables
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="contactname")
	private String contactname;
	
	@Column(name="contactphone")
	private String contactphone;
	
	@Column(name="cnp")
	private String cnp;
	
	@Column(name="iscompany")
	private Boolean iscompany;
	
    @OneToOne(mappedBy = "clients")
    private Company company;
    
    @OneToMany(mappedBy="clients")
    private Set<Inventory> inventory;
    
    @OneToMany(mappedBy="clients")
    private Set<Registration> registrations;
    
    @OneToMany(mappedBy="clients")
    private Set<Invoice> invoices;
    
    @OneToMany(mappedBy="clients")
    private Set<Reception> reception;
    
	public Client() {}
	
	public Client(String contactname, String contactphone, Boolean iscompany) {
		this.contactname = contactname;
		this.contactphone = contactphone;
		this.iscompany = iscompany;
	}

	public Client(String contactname, String contactphone, String cnp, Boolean iscompany) {
		this.contactname = contactname;
		this.contactphone = contactphone;
		this.cnp = cnp;
		this.iscompany = iscompany;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	
	public String getContactphone() {
		return contactphone;
	}
	
	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}

	public Boolean getIscompany() {
		return iscompany;
	}

	public void setIscompany(Boolean iscompany) {
		this.iscompany = iscompany;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Set<Reception> getReception() {
		return reception;
	}

	public void setReception(Set<Reception> reception) {
		this.reception = reception;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", contactname=" + contactname + ", contactphone=" + contactphone + ", iscompany="
				+ iscompany + "]";
	}

}
