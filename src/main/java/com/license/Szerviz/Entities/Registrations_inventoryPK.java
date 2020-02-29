package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Registrations_inventoryPK implements Serializable {
	private static final long serialVersionUID = 1050058558598201643L;
	protected Registration registrations;
	protected Inventory inventory;
	
	public Registrations_inventoryPK() {
	}

	public Registrations_inventoryPK(Registration registrations, Inventory inventory) {
		this.registrations = registrations;
		this.inventory = inventory;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventory == null) ? 0 : inventory.hashCode());
		result = prime * result + ((registrations == null) ? 0 : registrations.hashCode());
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
		if (inventory == null) {
			if (other.inventory != null)
				return false;
		} else if (!inventory.equals(other.inventory))
			return false;
		if (registrations == null) {
			if (other.registrations != null)
				return false;
		} else if (!registrations.equals(other.registrations))
			return false;
		return true;
	}
	
	
}
