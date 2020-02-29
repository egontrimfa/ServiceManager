package com.license.Szerviz.Entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Auto_pieces")
@Table(name = "auto_pieces", catalog = "postgres", schema = "public")
public class Auto_pieces implements Serializable {

private static final long serialVersionUID = 369973511259634141L;
	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "autopiecename")
	private String autopiecename;

	@Column(name = "autopieceunitename")
	private String autopieceunitename;
	
    @OneToMany(mappedBy="auto_pieces")
    private Set<Replaced> replaceables;
    
    @OneToMany(mappedBy="auto_pieces")
    private Set<Inventory> inventory;

    @OneToMany(mappedBy="receptions")
    private Set<Receptions_auto_pieces> receptions_auto_pieces;
    
	public Auto_pieces() {
	}

	public Auto_pieces(String id, String autopiecename, String autopieceunitname) {
		this.id = id;
		this.autopiecename = autopiecename;
		this.autopieceunitename = autopieceunitname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Set<Replaced> getReplaceables() {
		return replaceables;
	}

	public void setReplaceables(Set<Replaced> replaceables) {
		this.replaceables = replaceables;
	}

	public Set<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(Set<Inventory> inventory) {
		this.inventory = inventory;
	}

	public Set<Receptions_auto_pieces> getReceptions_auto_pieces() {
		return receptions_auto_pieces;
	}

	public void setReceptions_auto_pieces(Set<Receptions_auto_pieces> receptions_auto_pieces) {
		this.receptions_auto_pieces = receptions_auto_pieces;
	}

	@Override
	public String toString() {
		return "Auto_pieces [id=" + id + ", autopiecename=" + autopiecename + ", autopieceunitename="
				+ autopieceunitename + "]";
	}
}