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
	private Float newjobprice;
	
	@Column(name="jobname")
	private String jobname;
	
	@Column(name="jobunitename")
	private String jobunitename;
	
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

	public Registration_job(Integer jobsid, Integer registrationsid, Float newjobprice) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.newjobprice = newjobprice;
	}

	public Registration_job(Integer jobsid, Integer registrationsid, Integer usersid, Float newjobprice) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.usersid = usersid;
		this.newjobprice = newjobprice;
	}
	
	public Registration_job(Integer jobsid, Integer registrationsid, Integer usersid, Float newjobprice,
			String jobname) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.usersid = usersid;
		this.newjobprice = newjobprice;
		this.jobname = jobname;
	}

	public Registration_job(Integer jobsid, Integer registrationsid, Integer usersid, Float newjobprice, String jobname,
			String jobunitename) {
		this.jobsid = jobsid;
		this.registrationsid = registrationsid;
		this.usersid = usersid;
		this.newjobprice = newjobprice;
		this.jobname = jobname;
		this.jobunitename = jobunitename;
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

	public Float getNewjobprice() {
		return newjobprice;
	}

	public void setNewjobprice(Float newjobprice) {
		this.newjobprice = newjobprice;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getJobunitename() {
		return jobunitename;
	}

	public void setJobunitename(String jobunitename) {
		this.jobunitename = jobunitename;
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
		return "Registration_job [jobsid=" + jobsid + ", registrationsid=" + registrationsid + ", usersid=" + usersid
				+ ", newjobprice=" + newjobprice + ", jobname=" + jobname + ", jobunitename=" + jobunitename + "]";
	}
}
