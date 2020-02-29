package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Invoice_itemPK implements Serializable {
	private static final long serialVersionUID = -6001662181681020713L;
	
	protected int itemnumber;
	protected Invoice invoices;
	
	public Invoice_itemPK() {
	}

	public Invoice_itemPK(int itemnumber, Invoice invoices) {
		this.itemnumber = itemnumber;
		this.invoices = invoices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoices == null) ? 0 : invoices.hashCode());
		result = prime * result + itemnumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice_itemPK other = (Invoice_itemPK) obj;
		if (invoices == null) {
			if (other.invoices != null)
				return false;
		} else if (!invoices.equals(other.invoices))
			return false;
		if (itemnumber != other.itemnumber)
			return false;
		return true;
	}
}
