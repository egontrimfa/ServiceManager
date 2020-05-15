package com.license.Szerviz.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Job")
@Table(name="jobs", catalog="postgres", schema="public")
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="jobname")
	private String jobname;
	
	@Column(name="jobprice")
	private Float jobprice;
	
	@Column(name="jobunitename")
	private String jobunitename;
	
	@Column(name="joblenght")
	private Float joblenght;
	
    @OneToMany(mappedBy="jobs")
    private Set<Registration_job> job_registration;

	public Job() {
	}

	public Job(String jobname, Float jobprice) {
		this.jobname = jobname;
		this.jobprice = jobprice;
	}

	public Job(String jobname, Float jobprice, String jobunitename, Float joblenght) {
		this.jobname = jobname;
		this.jobprice = jobprice;
		this.jobunitename = jobunitename;
		this.joblenght = joblenght;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public Float getJobprice() {
		return jobprice;
	}

	public void setJobprice(Float jobprice) {
		this.jobprice = jobprice;
	}
	
	public String getJobunitename() {
		return jobunitename;
	}

	public void setJobunitename(String jobunitename) {
		this.jobunitename = jobunitename;
	}

	public Float getJoblenght() {
		return joblenght;
	}

	public void setJoblenght(Float joblenght) {
		this.joblenght = joblenght;
	}

	public Set<Registration_job> getJob_registration() {
		return job_registration;
	}

	public void setJob_registration(Set<Registration_job> job_registration) {
		this.job_registration = job_registration;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobname=" + jobname + ", jobprice=" + jobprice + ", jobunitename=" + jobunitename
				+ ", joblenght=" + joblenght + "]";
	}
}
