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
	private int id;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="unitepricein")
	private float unitepricein;
	
	@Column(name="unitepriceout")
	private float unitepriceout;
	
	@Column(name="datein")
	private Date datein;
	
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @ManyToOne
    @JoinColumn(name="autopiecesid", insertable = false, updatable = false)
    private Auto_pieces auto_pieces;
    
    @OneToMany(mappedBy="inventory")
    private Set<Registrations_inventory> registrations_inventory;
    
	public Inventory() {
	}
	
	public Inventory(int id, float quantity, float unitepricein, float unitepriceout, Date datein, Client clients,
			Auto_pieces auto_pieces) {
		this.id = id;
		this.quantity = quantity;
		this.unitepricein = unitepricein;
		this.unitepriceout = unitepriceout;
		this.datein = datein;
		this.clients = clients;
		this.auto_pieces = auto_pieces;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getUnitepricein() {
		return unitepricein;
	}

	public void setUnitepricein(float unitepricein) {
		this.unitepricein = unitepricein;
	}

	public float getUnitepriceout() {
		return unitepriceout;
	}

	public void setUnitepriceout(float unitepriceout) {
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

	public Auto_pieces getAutopieces() {
		return auto_pieces;
	}

	public void setAutopieces(Auto_pieces auto_pieces) {
		this.auto_pieces = auto_pieces;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", quantity=" + quantity + ", unitepricein=" + unitepricein + ", unitepriceout="
				+ unitepriceout + ", datein=" + datein + ", clients=" + clients + ", autopieces=" + auto_pieces + "]";
	}	
}
