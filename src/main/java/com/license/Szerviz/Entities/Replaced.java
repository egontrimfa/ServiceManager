package com.license.Szerviz.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Replaced")
@IdClass(replacePK.class)
@Table(name = "replaced", catalog = "postgres", schema = "public")
public class Replaced implements Serializable {

	private static final long serialVersionUID = -4991901521661993392L;

	@Id
	@Column(name = "autopiecesidfrom")
	private String autopiecesidfrom;

	@Id
	@Column(name = "autopiecesidto")
	private String autopiecesidto;
	
    @ManyToOne
    @JoinColumn(name="autopiecesidfrom", insertable = false, updatable = false)
    private Auto_pieces auto_pieces;
    
	public Replaced() {}
	
	public Replaced(String autopiecesidfrom, String autopiecesidto) {
		this.autopiecesidfrom = autopiecesidfrom;
		this.autopiecesidto = autopiecesidto;
	}



	public String getAutopiecesidto() {
		return autopiecesidto;
	}

	public void setAutopiecesidto(String autopiecesidto) {
		this.autopiecesidto = autopiecesidto;
	}

	public String getAutopiecesidfrom() {
		return autopiecesidfrom;
	}

	public void setAutopiecesidfrom(String autopiecesidfrom) {
		this.autopiecesidfrom = autopiecesidfrom;
	}

	public Auto_pieces getAuto_pieces() {
		return auto_pieces;
	}

	public void setAuto_pieces(Auto_pieces auto_pieces) {
		this.auto_pieces = auto_pieces;
	}

	@Override
	public String toString() {
		return "Replaced [autopiecesidfrom=" + autopiecesidfrom + ", autopiecesidto=" + autopiecesidto + "]";
	}
}