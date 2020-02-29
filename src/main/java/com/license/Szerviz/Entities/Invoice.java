package com.license.Szerviz.Entities;

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

@Entity(name="Invoice")
@Table(name="invoices", catalog="postgres", schema="public")
public class Invoice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "registrationsid")
	private Registration registrations;
	
    @ManyToOne
    @JoinColumn(name="usersid", insertable = false, updatable = false)
    private User users;
    
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @OneToMany(mappedBy="invoices")
    private Set<Invoice_item> invoice_item;

	public Invoice() {
	}

	public Invoice(int id, Registration registrations, User users, Client clients) {
		this.id = id;
		this.registrations = registrations;
		this.users = users;
		this.clients = clients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Registration getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Registration registrations) {
		this.registrations = registrations;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public Set<Invoice_item> getInvoice_item() {
		return invoice_item;
	}

	public void setInvoice_item(Set<Invoice_item> invoice_item) {
		this.invoice_item = invoice_item;
	}

	@Override
	public String toString() {
		return "Invoice [id=" + id + ", registration=" + registrations + ", users=" + users + ", clients=" + clients
				+ "]";
	} 
}
