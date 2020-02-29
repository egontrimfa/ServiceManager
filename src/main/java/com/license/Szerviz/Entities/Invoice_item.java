package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Invoice_item")
@IdClass(Invoice_itemPK.class)
@Table(name="invoice_items", catalog="postgres", schema="public")
public class Invoice_item {
	@Id
	@Column(name="itemnumber")
	private int itemnumber;
	
	@Id
    @ManyToOne
    @JoinColumn(name="invoicesid", insertable = false, updatable = false)
    private Invoice invoices;
	
	@Column(name="itemname")
	private String itemname;
	
	@Column(name="unitename")
	private String unitename;
	
	@Column(name="uniteprice")
	private float uniteprice;
	
	@Column(name="invoiceitemquantity")
	private float invoiceitemquantity;

	public Invoice_item() {
	}

	public Invoice_item(int itemnumber, Invoice invoices, String itemname, String unitename, float uniteprice,
			float invoiceitemquantity) {
		this.itemnumber = itemnumber;
		this.invoices = invoices;
		this.itemname = itemname;
		this.unitename = unitename;
		this.uniteprice = uniteprice;
		this.invoiceitemquantity = invoiceitemquantity;
	}

	public int getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(int itemnumber) {
		this.itemnumber = itemnumber;
	}

	public Invoice getInvoices() {
		return invoices;
	}

	public void setInvoices(Invoice invoices) {
		this.invoices = invoices;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getUnitename() {
		return unitename;
	}

	public void setUnitename(String unitename) {
		this.unitename = unitename;
	}

	public float getUniteprice() {
		return uniteprice;
	}

	public void setUniteprice(float uniteprice) {
		this.uniteprice = uniteprice;
	}

	public float getInvoiceitemquantity() {
		return invoiceitemquantity;
	}

	public void setInvoiceitemquantity(float invoiceitemquantity) {
		this.invoiceitemquantity = invoiceitemquantity;
	}

	@Override
	public String toString() {
		return "Invoice_item [itemnumber=" + itemnumber + ", invoices=" + invoices + ", itemname=" + itemname
				+ ", unitename=" + unitename + ", uniteprice=" + uniteprice + ", invoiceitemquantity="
				+ invoiceitemquantity + "]";
	}
}
