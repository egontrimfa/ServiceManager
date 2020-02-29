package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Job_registration")
@IdClass(Job_registrationPK.class)
@Table(name="job_registrations", catalog="postgres", schema="public")
public class Job_registration {
	@Id
    @ManyToOne
    @JoinColumn(name="jobs", insertable = false, updatable = false)
    private Job jobs;
	
	@Id
    @ManyToOne
    @JoinColumn(name="registrationsid", insertable = false, updatable = false)
    private Registration registrations;
	
    @ManyToOne
    @JoinColumn(name="usersid", insertable = false, updatable = false)
    private User users;
	
	@Column(name="newjobprice")
	private float newjobprice;

	public Job_registration() {
	}

	public Job_registration(Job jobs, Registration registrations, User users, float newjobprice) {
		this.jobs = jobs;
		this.registrations = registrations;
		this.users = users;
		this.newjobprice = newjobprice;
	}

	
	public Job getJobs() {
		return jobs;
	}

	public void setJobs(Job jobs) {
		this.jobs = jobs;
	}

	public Registration getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Registration registrations) {
		this.registrations = registrations;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public float getNewjobprice() {
		return newjobprice;
	}

	public void setNewjobprice(float newjobprice) {
		this.newjobprice = newjobprice;
	}

	
	
	@Override
	public String toString() {
		return "Job_registration [jobs=" + jobs + ", registrations=" + registrations + ", users=" + users
				+ ", newjobprice=" + newjobprice + "]";
	}
}
