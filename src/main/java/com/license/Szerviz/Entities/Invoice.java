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
	private Integer id;
	
	@Column(name="usersid")
	private Integer usersid;
	
	@Column(name="registrationsid")
	private Integer registrationsid;
	
	@Column(name="clientsid")
	private Integer clientsid;
	
    @ManyToOne
    @JoinColumn(name="usersid", insertable = false, updatable = false)
    private User users;
	
	@OneToOne
	@JoinColumn(name = "registrationsid", insertable = false, updatable = false)
	private Registration registrations;
    
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @OneToMany(mappedBy="invoices")
    private Set<Invoice_item> invoice_item;

	public Invoice() {
	}

	public Invoice(Integer usersid, Integer registrationsid, Integer clientsid) {
		this.usersid = usersid;
		this.registrationsid = registrationsid;
		this.clientsid = clientsid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getUsersid() {
		return usersid;
	}

	public void setUsersid(Integer usersid) {
		this.usersid = usersid;
	}

	public Integer getRegistrationsid() {
		return registrationsid;
	}

	public void setRegistrationsid(Integer registrationsid) {
		this.registrationsid = registrationsid;
	}

	public Integer getClientsid() {
		return clientsid;
	}

	public void setClientsid(Integer clientsid) {
		this.clientsid = clientsid;
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
		return "Invoice [id=" + id + ", usersid=" + usersid + ", registrationsid=" + registrationsid + ", clientsid="
				+ clientsid + "]";
	}
}
