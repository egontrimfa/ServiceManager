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
	private Integer receptionsid;
	
	@Id
	@Column(name="autopiecesid")
	private String autopiecesid;
	
	@Column(name="quantity")
	private Float quantity;
	
	@Column(name="unitepricein")
	private Float unitepricein;
	
	@Column(name="unitepriceout")
	private Float unitepriceout;
	
	@Column(name="vatitem")
	private Float vatitem;
	
    @ManyToOne
    @JoinColumn(name="receptionsid", insertable = false, updatable = false)
    private Reception receptions;

    @ManyToOne
    @JoinColumn(name="autopiecesid", insertable = false, updatable = false)
    private Auto_pieces auto_pieces;

	public Receptions_auto_pieces() {
	}

	public Receptions_auto_pieces(Integer receptionsid, String autopiecesid, Float quantity, Float unitepricein,
			Float unitepriceout, Float vatitem) {
		this.receptionsid = receptionsid;
		this.autopiecesid = autopiecesid;
		this.quantity = quantity;
		this.unitepricein = unitepricein;
		this.unitepriceout = unitepriceout;
		this.vatitem = vatitem;
	}
	
	public Integer getReceptionsid() {
		return receptionsid;
	}

	public void setReceptionsid(Integer receptionsid) {
		this.receptionsid = receptionsid;
	}

	public String getAutopiecesid() {
		return autopiecesid;
	}

	public void setAutopiecesid(String autopiecesid) {
		this.autopiecesid = autopiecesid;
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

	public Float getVatitem() {
		return vatitem;
	}

	public void setVatitem(Float vatitem) {
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
		return "Receptions_auto_pieces [receptionsid=" + receptionsid + ", autopiecesid=" + autopiecesid + ", quantity="
				+ quantity + ", unitepricein=" + unitepricein + ", unitepriceout=" + unitepriceout + ", vatitem="
				+ vatitem + "]";
	}
}
