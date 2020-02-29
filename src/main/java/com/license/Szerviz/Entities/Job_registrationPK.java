package com.license.Szerviz.Entities;

import java.io.Serializable;

public class Job_registrationPK implements Serializable {
	private static final long serialVersionUID = -1892096872764355892L;

	protected Job jobs;
	protected Registration registrations;
	
	public Job_registrationPK() {

	}
	
	
	

	public Job_registrationPK(Job jobs, Registration registrations) {
		this.jobs = jobs;
		this.registrations = registrations;
	}
	




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobs == null) ? 0 : jobs.hashCode());
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
		Job_registrationPK other = (Job_registrationPK) obj;
		if (jobs == null) {
			if (other.jobs != null)
				return false;
		} else if (!jobs.equals(other.jobs))
			return false;
		if (registrations == null) {
			if (other.registrations != null)
				return false;
		} else if (!registrations.equals(other.registrations))
			return false;
		return true;
	}
	
	
}
