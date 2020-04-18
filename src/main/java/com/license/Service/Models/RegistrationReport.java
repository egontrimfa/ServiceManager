package com.license.Service.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.license.Szerviz.Entities.Inventory;

@Entity(name="RegistrationReport")
@Table(name="registrations_inventory", catalog="postgres", schema="public")
public class RegistrationReport {
	@Id
	@Column(name="inventoryid")
	private Integer inventoryid;
	
	@Column(name="newuniteprice")
	private float newuniteprice;
	
	@Column(name="quantity")
	private float quantity;
	
    @ManyToOne
    @JoinColumn(name="inventoryid", insertable = false, updatable = false)
    private Inventory inventory;

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

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "RegistrationReport [inventoryid=" + inventoryid + ", newuniteprice=" + newuniteprice + ", quantity="
				+ quantity + ", inventory=" + inventory + "]";
	}
}
