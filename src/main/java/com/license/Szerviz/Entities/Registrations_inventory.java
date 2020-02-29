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
    @ManyToOne
    @JoinColumn(name="registrationsid", insertable = false, updatable = false)
    private Registration registrations;
    
	@Id
    @ManyToOne
    @JoinColumn(name="inventoryid", insertable = false, updatable = false)
    private Inventory inventory;
	
	@Column(name="newuniteprice")
	private float newuniteprice;
	
	@Column(name="quantity")
	private float quantity;
	
	public Registrations_inventory() {
	}

	public Registrations_inventory(float newuniteprice, float quantity, Registration registrations,
			Inventory inventory) {
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
		this.registrations = registrations;
		this.inventory = inventory;
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

	
	
	@Override
	public String toString() {
		return "Registrations_inventory [newuniteprice=" + newuniteprice + ", quantity=" + quantity + ", registrations="
				+ registrations + ", inventorys=" + inventory + "]";
	}
}
