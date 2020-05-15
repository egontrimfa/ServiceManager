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
	private Float newuniteprice;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="autopiecesid")
	private String autopiecesid;
	
	@Column(name="autopiecename")
	private String autopiecename;
	
	@Column(name="autopieceunitename")
	private String autopieceunitename;
	
    @ManyToOne
    @JoinColumn(name="registrationsid", insertable = false, updatable = false)
    private Registration registrations;
    
    @ManyToOne
    @JoinColumn(name="inventoryid", insertable = false, updatable = false)
    private Inventory inventory;
	
	public Registrations_inventory() {
	}

	public Registrations_inventory(Integer registrationsid, Integer inventoryid, Float newuniteprice, Float quantity) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
	}
		
	public Registrations_inventory(Integer registrationsid, Integer inventoryid, Float newuniteprice, Float quantity,
			String autopiecename) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
		this.autopiecename = autopiecename;
	}

	public Registrations_inventory(Integer registrationsid, Integer inventoryid, Float newuniteprice, Float quantity,
			String autopiecename, String autopieceunitename) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
		this.autopiecename = autopiecename;
		this.autopieceunitename = autopieceunitename;
	}

	public Registrations_inventory(Integer registrationsid, Integer inventoryid, Float newuniteprice, Float quantity,
			String autopiecesid, String autopiecename, String autopieceunitename) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
		this.newuniteprice = newuniteprice;
		this.quantity = quantity;
		this.autopiecesid = autopiecesid;
		this.autopiecename = autopiecename;
		this.autopieceunitename = autopieceunitename;
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

	public Float getNewuniteprice() {
		return newuniteprice;
	}

	public void setNewuniteprice(Float newuniteprice) {
		this.newuniteprice = newuniteprice;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public String getAutopiecesid() {
		return autopiecesid;
	}

	public void setAutopiecesid(String autopiecesid) {
		this.autopiecesid = autopiecesid;
	}

	public String getAutopiecename() {
		return autopiecename;
	}

	public void setAutopiecename(String autopiecename) {
		this.autopiecename = autopiecename;
	}

	public String getAutopieceunitename() {
		return autopieceunitename;
	}

	public void setAutopieceunitename(String autopieceunitename) {
		this.autopieceunitename = autopieceunitename;
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
				+ ", newuniteprice=" + newuniteprice + ", quantity=" + quantity + ", autopiecesid=" + autopiecesid
				+ ", autopiecename=" + autopiecename + ", autopieceunitename=" + autopieceunitename + "]";
	}
}
