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
import javax.persistence.Table;

@Entity(name="Inventory")
@Table(name="inventory", catalog="postgres", schema="public")
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="autopiecesid")
	private String autopiecesid;
	
	@Column(name="clientsid")
	private Integer clientsid;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="unitepricein")
	private Float unitepricein;
	
	@Column(name="unitepriceout")
	private Float unitepriceout;
	
	@Column(name="datein")
	private Date datein;
	
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @ManyToOne
    @JoinColumn(name="autopiecesid", insertable = false, updatable = false)
    private Auto_pieces auto_pieces;
    
    @OneToMany
    @JoinColumn(name = "inventoryid")
    private Set<Registrations_inventory> registrations_inventory;
    
	public Inventory() {
	}

	public Inventory(String autopiecesid, Integer clientsid, Float quantity, Float unitepricein, Float unitepriceout,
			Date datein) {
		this.autopiecesid = autopiecesid;
		this.clientsid = clientsid;
		this.quantity = quantity;
		this.unitepricein = unitepricein;
		this.unitepriceout = unitepriceout;
		this.datein = datein;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAutopiecesid() {
		return autopiecesid;
	}
	
	public void setAutopiecesid(String autopiecesid) {
		this.autopiecesid = autopiecesid;
	}
	
	public Integer getClientsid() {
		return clientsid;
	}
	
	public void setClientsid(Integer clientsid) {
		this.clientsid = clientsid;
	}
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	
	public Float getUnitepricein() {
		return unitepricein;
	}
	
	public void setUnitepricein(Float unitepricein) {
		this.unitepricein = unitepricein;
	}
	
	public Float getUnitepriceout() {
		return unitepriceout;
	}
	
	public void setUnitepriceout(Float unitepriceout) {
		this.unitepriceout = unitepriceout;
	}

	public Date getDatein() {
		return datein;
	}
	
	public void setDatein(Date datein) {
		this.datein = datein;
	}
	
	public Client getClients() {
		return clients;
	}
	
	public void setClients(Client clients) {
		this.clients = clients;
	}
	
	public Auto_pieces getAuto_pieces() {
		return auto_pieces;
	}
	
	public void setAuto_pieces(Auto_pieces auto_pieces) {
		this.auto_pieces = auto_pieces;
	}
	
	public Set<Registrations_inventory> getRegistrations_inventory() {
		return registrations_inventory;
	}
	
	public void setRegistrations_inventory(Set<Registrations_inventory> registrations_inventory) {
		this.registrations_inventory = registrations_inventory;
	}
	
	@Override	
	public String toString() {
		return "Inventory [id=" + id + ", autopiecesid=" + autopiecesid + ", clientsid=" + clientsid + ", quantity="
				+ quantity + ", unitepricein=" + unitepricein + ", unitepriceout=" + unitepriceout + ", datein="
				+ datein + "]";
	}	
}
