package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Registrations_inventory")
@IdClass(Registrations_inventoryPK.class)
@Table(name="registrations_inventory", catalog="postgres", schema="public")
public class Registrations_inventory {
	@Id
	@Column(name="registrationsid")
	private Integer registrationsid;
	
	@Id
	@Column(name="inventoryid")
	private Integer inventoryid;
	
	@Column(name="newuniteprice")
	private float newuniteprice;
	
	@Column(name="quantity")
	private float quantity;
	
    @ManyToOne
    @JoinColumn(name="registrationsid", insertable = false, updatable = false)
    private Registration registrations;
    
    @ManyToOne
    @JoinColumn(name="inventoryid", insertable = false, updatable = false)
    private Inventory inventory;
	
	public Registrations_inventory() {
	}

	public Registrations_inventory(Integer registrationsid, Integer inventoryid, float newuniteprice, float quantity) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
	}
	
	public Integer getRegistrationsid() {
		return registrationsid;
	}

	public void setRegistrationsid(Integer registrationsid) {
		this.registrationsid = registrationsid;
	}

	public Integer getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
	}

	public float getNewuniteprice() {
		return newuniteprice;
	}

	public void setNewuniteprice(float newuniteprice) {
		this.newuniteprice = newuniteprice;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public Registration getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Registration registrations) {
		this.registrations = registrations;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	
	@Override
	public String toString() {
		return "Registrations_inventory [registrationsid=" + registrationsid + ", inventoryid=" + inventoryid
				+ ", newuniteprice=" + newuniteprice + ", quantity=" + quantity + "]";
	}
}
