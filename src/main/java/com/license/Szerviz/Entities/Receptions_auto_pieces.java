package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Receptions_auto_pieces")
@IdClass(Receptions_auto_piecesPK.class)
@Table(name="receptions_auto_pieces", catalog="postgres", schema="public")
public class Receptions_auto_pieces {
	@Id
	@Column(name="receptionsid")
	private int receptionsid;
	
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
	
    @ManyToOne
    @JoinColumn(name="receptionsid", insertable = false, updatable = false)
    private Reception receptions;

    @ManyToOne
    @JoinColumn(name="autopiecesid", insertable = false, updatable = false)
    private Auto_pieces auto_pieces;

	public Receptions_auto_pieces() {
	}

	public Receptions_auto_pieces(int receptionsid, String autopiecesid, float quantity, float unitepricein,
			float unitepriceout, float vatitem) {
		this.receptionsid = receptionsid;
		this.autopiecesid = autopiecesid;
		this.quantity = quantity;
		this.unitepricein = unitepricein;
		this.unitepriceout = unitepriceout;
		this.vatitem = vatitem;
	}
	
	public int getReceptionsid() {
		return receptionsid;
	}

	public void setReceptionsid(int receptionsid) {
		this.receptionsid = receptionsid;
	}

	public String getAutopiecesid() {
		return autopiecesid;
	}

	public void setAutopiecesid(String autopiecesid) {
		this.autopiecesid = autopiecesid;
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

	public float getVatitem() {
		return vatitem;
	}

	public void setVatitem(float vatitem) {
		this.vatitem = vatitem;
	}

	public Reception getReceptions() {
		return receptions;
	}

	public void setReceptions(Reception receptions) {
		this.receptions = receptions;
	}

	public Auto_pieces getAuto_pieces() {
		return auto_pieces;
	}

	public void setAuto_pieces(Auto_pieces auto_pieces) {
		this.auto_pieces = auto_pieces;
	}
	
	@Override
	public String toString() {
		return "Receptions_auto_pieces [receptions=" + receptions + ", auto_pieces=" + auto_pieces + ", quantity="
				+ quantity + ", unitepricein=" + unitepricein + ", unitepriceout=" + unitepriceout + ", vatitem="
				+ vatitem + "]";
	}
}
