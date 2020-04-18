package com.license.Service.Models;

public class CommandModel {
	private String autopiecename;
	private String autopieceunitename;
	private Float quantity;
	private Float newuniteprice;
	private Float valuesum;
	private Float vat;
	private Float total;
	
	public CommandModel() {
	}

	public CommandModel(String autopiecename, String autopieceunitename, Float quantity, Float newuniteprice,
			Float valuesum, Float vat, Float total) {
		this.autopiecename = autopiecename;
		this.autopieceunitename = autopieceunitename;
		this.quantity = quantity;
		this.newuniteprice = newuniteprice;
		this.valuesum = valuesum;
		this.vat = vat;
		this.total = total;
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
	
	public Float getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}
	
	public Float getNewuniteprice() {
		return newuniteprice;
	}
	
	public void setNewuniteprice(Float newuniteprice) {
		this.newuniteprice = newuniteprice;
	}
	
	public Float getValuesum() {
		return valuesum;
	}
	
	public void setValuesum(Float valuesum) {
		this.valuesum = valuesum;
	}
	
	public Float getVat() {
		return vat;
	}
	
	public void setVat(Float vat) {
		this.vat = vat;
	}
	
	public Float getTotal() {
		return total;
	}
	
	public void setTotal(Float total) {
		this.total = total;
	}

	
	@Override
	public String toString() {
		return "CommandModel [autopiecename=" + autopiecename + ", autopieceunitename=" + autopieceunitename
				+ ", quantity=" + quantity + ", newuniteprice=" + newuniteprice + ", valuesum=" + valuesum + ", vat="
				+ vat + ", total=" + total + "]";
	}
	
		
}
