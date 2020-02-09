package com.license.Szerviz.Entities;

import java.io.Serializable;

public class replacePK implements Serializable {

	private static final long serialVersionUID = 2684256309449890672L;

	protected String autopiecesidfrom;
	protected String autopiecesidto;

	public replacePK() {
	}

	public replacePK(String autopiecesidfrom, String autopiecesidto) {
		this.autopiecesidfrom = autopiecesidfrom;
		this.autopiecesidto = autopiecesidto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autopiecesidfrom == null) ? 0 : autopiecesidfrom.hashCode());
		result = prime * result + ((autopiecesidto == null) ? 0 : autopiecesidto.hashCode());
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
		replacePK other = (replacePK) obj;
		if (autopiecesidfrom == null) {
			if (other.autopiecesidfrom != null)
				return false;
		} else if (!autopiecesidfrom.equals(other.autopiecesidfrom))
			return false;
		if (autopiecesidto == null) {
			if (other.autopiecesidto != null)
				return false;
		} else if (!autopiecesidto.equals(other.autopiecesidto))
			return false;
		return true;
	}
}