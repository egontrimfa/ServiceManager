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
	private int id;
	
	@Column(name="rolename")
	private String rolename;
	
    @OneToMany(mappedBy="roles")
    private Set<User> users;

	public Role() {
	}
	
	

	public Role(int id, String rolename, Set<User> users) {
		this.id = id;
		this.rolename = rolename;
		this.users = users;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
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
		return "Role [id=" + id + ", rolename=" + rolename + ", users=" + users + "]";
	} 
}
