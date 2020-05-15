package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Invoice_itemPK implements Serializable {
	private static final long serialVersionUID = -6001662181681020713L;
	
	protected Integer invoicesid;
	protected Integer itemnumber;
	
	public Invoice_itemPK() {
	}

	public Invoice_itemPK(Integer invoicesid, Integer itemnumber) {
		this.invoicesid = invoicesid;
		this.itemnumber = itemnumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invoicesid == null) ? 0 : invoicesid.hashCode());
		result = prime * result + ((itemnumber == null) ? 0 : itemnumber.hashCode());
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
		if (invoicesid == null) {
			if (other.invoicesid != null)
				return false;
		} else if (!invoicesid.equals(other.invoicesid))
			return false;
		if (itemnumber == null) {
			if (other.itemnumber != null)
				return false;
		} else if (!itemnumber.equals(other.itemnumber))
			return false;
		return true;
	}
	
	
}
