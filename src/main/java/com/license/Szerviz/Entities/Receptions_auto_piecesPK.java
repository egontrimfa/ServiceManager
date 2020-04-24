package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Receptions_auto_piecesPK implements Serializable {
	private static final long serialVersionUID = 494762005644315231L;

	protected Integer receptionsid;
	protected String autopiecesid;
	
	public Receptions_auto_piecesPK() {
	}

	
	public Receptions_auto_piecesPK(Integer receptionsid, String autopiecesid) {
		this.receptionsid = receptionsid;
		this.autopiecesid = autopiecesid;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autopiecesid == null) ? 0 : autopiecesid.hashCode());
		result = prime * result + receptionsid;
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
		Receptions_auto_piecesPK other = (Receptions_auto_piecesPK) obj;
		if (autopiecesid == null) {
			if (other.autopiecesid != null)
				return false;
		} else if (!autopiecesid.equals(other.autopiecesid))
			return false;
		if (receptionsid != other.receptionsid)
			return false;
		return true;
	}

}
