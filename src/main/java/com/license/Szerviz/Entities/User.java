package com.license.Szerviz.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="User")
@Table(name="users", catalog="postgres", schema="public")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="rolesid")
	private Integer rolesid;
	
	@Column(name="username")
	private String username;
	
	@Column(name="userpassword")
	private String userpassword;
	
    @ManyToOne
    @JoinColumn(name="rolesid", insertable = false, updatable = false)
    private Role roles;

    @OneToMany(mappedBy="users")
    private Set<Registration_job> job_registration;
    
    @OneToMany(mappedBy="users")
    private Set<Invoice> invoices;
    
	public User() {
	}

	public User(Integer rolesid, String username, String userpassword) {
		super();
		this.rolesid = rolesid;
		this.username = username;
		this.userpassword = userpassword;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRolesid() {
		return rolesid;
	}

	public void setRolesid(Integer rolesid) {
		this.rolesid = rolesid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public Role getRoles() {
		return roles;
	}

	public void setRoles(Role roles) {
		this.roles = roles;
	}
	
	public Set<Registration_job> getJob_registration() {
		return job_registration;
	}

	public void setJob_registration(Set<Registration_job> job_registration) {
		this.job_registration = job_registration;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", rolesid=" + rolesid + ", username=" + username + ", userpassword=" + userpassword
				+ "]";
	}
}
