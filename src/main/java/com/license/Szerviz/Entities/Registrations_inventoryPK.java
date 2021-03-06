package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Registrations_inventoryPK implements Serializable {
	private static final long serialVersionUID = 1050058558598201643L;
	protected Integer registrationsid;
	protected Integer inventoryid;
	
	public Registrations_inventoryPK() {
	}

	public Registrations_inventoryPK(Integer registrationsid, Integer inventoryid) {
		this.registrationsid = registrationsid;
		this.inventoryid = inventoryid;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventoryid == null) ? 0 : inventoryid.hashCode());
		result = prime * result + ((registrationsid == null) ? 0 : registrationsid.hashCode());
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
		Registrations_inventoryPK other = (Registrations_inventoryPK) obj;
		if (inventoryid == null) {
			if (other.inventoryid != null)
				return false;
		} else if (!inventoryid.equals(other.inventoryid))
			return false;
		if (registrationsid == null) {
			if (other.registrationsid != null)
				return false;
		} else if (!registrationsid.equals(other.registrationsid))
			return false;
		return true;
	}
}
