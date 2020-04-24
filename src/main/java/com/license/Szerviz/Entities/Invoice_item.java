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
	private Integer itemnumber;
	
	@Id
    @ManyToOne
    @JoinColumn(name="invoicesid", insertable = false, updatable = false)
    private Invoice invoices;
	
	@Column(name="itemname")
	private String itemname;
	
	@Column(name="unitename")
	private String unitename;
	
	@Column(name="uniteprice")
	private Float uniteprice;
	
	@Column(name="invoiceitemquantity")
	private Float invoiceitemquantity;

	public Invoice_item() {
	}

	public Invoice_item(Integer itemnumber, Invoice invoices, String itemname, String unitename, Float uniteprice,
			Float invoiceitemquantity) {
		this.itemnumber = itemnumber;
		this.invoices = invoices;
		this.itemname = itemname;
		this.unitename = unitename;
		this.uniteprice = uniteprice;
		this.invoiceitemquantity = invoiceitemquantity;
	}

	public Integer getItemnumber() {
		return itemnumber;
	}

	public void setItemnumber(Integer itemnumber) {
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

	public Float getUniteprice() {
		return uniteprice;
	}

	public void setUniteprice(Float uniteprice) {
		this.uniteprice = uniteprice;
	}

	public Float getInvoiceitemquantity() {
		return invoiceitemquantity;
	}

	public void setInvoiceitemquantity(Float invoiceitemquantity) {
		this.invoiceitemquantity = invoiceitemquantity;
	}

	@Override
	public String toString() {
		return "Invoice_item [itemnumber=" + itemnumber + ", invoices=" + invoices + ", itemname=" + itemname
				+ ", unitename=" + unitename + ", uniteprice=" + uniteprice + ", invoiceitemquantity="
				+ invoiceitemquantity + "]";
	}
}
