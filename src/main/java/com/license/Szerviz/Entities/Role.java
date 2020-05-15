package com.license.Szerviz.Entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Role")
@Table(name="roles", catalog="postgres", schema="public")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="rolename")
	private String rolename;
	
    @OneToMany(mappedBy="roles")
    private Set<User> users;

	public Role() {
	}

	public Role(Integer id, String rolename) {
		this.id = id;
		this.rolename = rolename;
	}

	public Role(String rolename) {
		this.rolename = rolename;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return rolename.toUpperCase();
	}

}
