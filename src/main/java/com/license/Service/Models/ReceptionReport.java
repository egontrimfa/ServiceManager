package com.license.Service.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ReceptionReport")
@Table(name="receptions_auto_pieces", catalog="postgres", schema="public")
public class ReceptionReport {
	@Id
	@Column(name="autopiecesid")
	private String autopiecesid;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="unitepricein")
	private float unitepricein;
	
	@Column(name="unitepriceout")
	private float unitepriceout;
	
	@Column(name="vatitem")
	private float vatitem;

	public String getAutopiecesid() {
		return autopiecesid;
	}

	public float getQuantity() {
		return quantity;
	}

	public float getUnitepricein() {
		return unitepricein;
	}

	public float getUnitepriceout() {
		return unitepriceout;
	}

	public float getVatitem() {
		return vatitem;
	}

	@Override
	public String toString() {
		return "ReceptionReport [autopiecesid=" + autopiecesid + ", quantity=" + quantity + ", unitepricein="
				+ unitepricein + ", unitepriceout=" + unitepriceout + ", vatitem=" + vatitem + "]";
	}
}
