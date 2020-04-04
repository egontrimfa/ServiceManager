package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Registration_jobPK implements Serializable {
	private static final long serialVersionUID = -1892096872764355892L;

	protected Integer jobsid;
	protected Integer registrationsid;
	
	public Registration_jobPK() {
	}

	
	public Registration_jobPK(Integer jobsid, Integer registrationsid) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
	}


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobsid == null) ? 0 : jobsid.hashCode());
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
		Registration_jobPK other = (Registration_jobPK) obj;
		if (jobsid == null) {
			if (other.jobsid != null)
				return false;
		} else if (!jobsid.equals(other.jobsid))
			return false;
		if (registrationsid == null) {
			if (other.registrationsid != null)
				return false;
		} else if (!registrationsid.equals(other.registrationsid))
			return false;
		return true;
	}	
}
