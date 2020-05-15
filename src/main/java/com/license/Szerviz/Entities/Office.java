package com.license.Szerviz.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Office")
@Table(name="offices", catalog="postgres", schema="public")
public class Office {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cif")
	private String cif;
	
	@Column(name="rc")
	private String rc;
	
	@Column(name="capital")
	private Integer capital;
	
	@Column(name="address")
	private String address;
	
	@Column(name="county")
	private String county;
	
	@Column(name="bank")
	private String bank;
	
	@Column(name="iban")
	private String iban;
	
	@Column(name="phonenumber")
	private String phonenumber;
	
	@Column(name="globaldiff")
	private String globaldiff;
	
	public Office() {
	}

	public Office(String name, String cif, String rc, Integer capital, String address, String county, String bank,
			String iban, String phonenumber, String globaldiff) {
		this.name = name;
		this.cif = cif;
		this.rc = rc;
		this.capital = capital;
		this.address = address;
		this.county = county;
		this.bank = bank;
		this.iban = iban;
		this.phonenumber = phonenumber;
		this.globaldiff = globaldiff;
	}

	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getCif() {
		return cif;
	}
	

	public void setCif(String cif) {
		this.cif = cif;
	}
	

	public String getRc() {
		return rc;
	}
	

	public void setRc(String rc) {
		this.rc = rc;
	}
	

	public Integer getCapital() {
		return capital;
	}
	

	public void setCapital(Integer capital) {
		this.capital = capital;
	}

	public String getAddress() {
		return address;
	}
	

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getCounty() {
		return county;
	}
	

	public void setCounty(String county) {
		this.county = county;
	}
	

	public String getBank() {
		return bank;
	}
	

	public void setBank(String bank) {
		this.bank = bank;
	}
	

	public String getIban() {
		return iban;
	}
	

	public void setIban(String iban) {
		this.iban = iban;
	}
	

	public String getPhonenumber() {
		return phonenumber;
	}
	

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	

	public String getGlobaldiff() {
		return globaldiff;
	}
	

	public void setGlobaldiff(String globaldiff) {
		this.globaldiff = globaldiff;
	}

	
	@Override
	public String toString() {
		return "Office [id=" + id + ", name=" + name + ", cif=" + cif + ", rc=" + rc + ", capital=" + capital
				+ ", address=" + address + ", county=" + county + ", bank=" + bank + ", iban=" + iban + ", phonenumber="
				+ phonenumber + ", globaldiff=" + globaldiff + "]";
	}
	
	
}
