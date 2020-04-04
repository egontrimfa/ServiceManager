package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Registration_job")
@IdClass(Registration_jobPK.class)
@Table(name="registration_jobs", catalog="postgres", schema="public")
public class Registration_job {
	@Id
	@Column(name="jobsid")
	private Integer jobsid;	
	
	@Id
	@Column(name="registrationsid")
	private Integer registrationsid;	
	
	@Column(name="usersid")
	private Integer usersid;	
	
	@Column(name="newjobprice")
	private float newjobprice;
	
    @ManyToOne
    @JoinColumn(name="jobsid", insertable = false, updatable = false)
    private Job jobs;
	
    @ManyToOne
    @JoinColumn(name="registrationsid", insertable = false, updatable = false)
    private Registration registrations;
	
    @ManyToOne
    @JoinColumn(name="usersid", insertable = false, updatable = false)
    private User users;
    
	public Registration_job() {
	}

	public Registration_job(Integer jobsid, Integer registrationsid, float newjobprice) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.newjobprice = newjobprice;
	}

	public Registration_job(Integer jobsid, Integer registrationsid, Integer usersid, float newjobprice) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.usersid = usersid;
		this.newjobprice = newjobprice;
	}

	public Integer getJobsid() {
		return jobsid;
	}

	public void setJobsid(Integer jobsid) {
		this.jobsid = jobsid;
	}

	public Integer getRegistrationsid() {
		return registrationsid;
	}

	public void setRegistrationsid(Integer registrationsid) {
		this.registrationsid = registrationsid;
	}

	public Integer getUsersid() {
		return usersid;
	}

	public void setUsersid(Integer usersid) {
		this.usersid = usersid;
	}

	public float getNewjobprice() {
		return newjobprice;
	}

	public void setNewjobprice(float newjobprice) {
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
	
	@Override
	public String toString() {
		return "Job_registration [jobsid=" + jobsid + ", registrationsid=" + registrationsid + ", usersid=" + usersid
				+ ", newjobprice=" + newjobprice + "]";
	}
}
