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
	private int id;
	
	@Column(name="jobname")
	private String jobname;
	
	@Column(name="jobprice")
	private float jobprice;
	
    @OneToMany(mappedBy="jobs")
    private Set<Job_registration> job_registration;

	public Job() {
	}

	public Job(String jobname, float jobprice) {
		this.jobname = jobname;
		this.jobprice = jobprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobname() {
		return jobname;
	}

	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public float getJobprice() {
		return jobprice;
	}

	public void setJobprice(float jobprice) {
		this.jobprice = jobprice;
	}

	public Set<Job_registration> getJob_registration() {
		return job_registration;
	}

	public void setJob_registration(Set<Job_registration> job_registration) {
		this.job_registration = job_registration;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", jobname=" + jobname + ", jobprice=" + jobprice + ", job_registration="
				+ job_registration + "]";
	}
}
