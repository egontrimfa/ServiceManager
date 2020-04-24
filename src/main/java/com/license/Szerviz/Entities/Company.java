package com.license.Szerviz.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Company")
@Table(name="companies", catalog="postgres", schema="public")
public class Company implements Serializable {
	
	private static final long serialVersionUID = -170375422885594196L;

	//companies table's columns implementation to variables
	@Id
	@Column(name="clientsid")
	private Integer clientsid;
	
	@Column(name="companyphone")
	private String companyphone;
	
	@Column(name="companyname")
	private String companyname;
	
	@Column(name="companyaddress")
	private String companyaddress;
	
	@Column(name="cif")
	private String cif;
	
	@Column(name="regnr")
	private String regnr;
	
	@Column(name="bank")
	private String bank;
	
	@Column(name="iban")
	private String iban;
	
	@Column(name="branchoffice")
	private String branchoffice;
	
	@OneToOne
	@JoinColumn(name = "clientsid")
	private Client clients;
	
	public Company() {}

	public Company(Integer clientsid, String companyphone, String companyname, String companyaddress, String cif,
			String regnr, String bank, String iban, String branchoffice) {
		this.clientsid = clientsid;
		this.companyphone = companyphone;
		this.companyname = companyname;
		this.companyaddress = companyaddress;
		this.cif = cif;
		this.regnr = regnr;
		this.bank = bank;
		this.iban = iban;
		this.branchoffice = branchoffice;
	}

	public Integer getClientsid() {
		return clientsid;
	}

	public void setClientsid(Integer clientsid) {
		this.clientsid = clientsid;
	}

	public String getCompanyphone() {
		return companyphone;
	}

	public void setCompanyphone(String companyphone) {
		this.companyphone = companyphone;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
		this.regnr = regnr;
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

	public String getBranchoffice() {
		return branchoffice;
	}

	public void setBranchoffice(String branchoffice) {
		this.branchoffice = branchoffice;
	}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	
	@Override
	public String toString() {
		return "Company [clientsid=" + clientsid + ", companyphone=" + companyphone + ", companyname=" + companyname
				+ ", companyaddress=" + companyaddress + ", cif=" + cif + ", regnr=" + regnr + ", bank=" + bank
				+ ", iban=" + iban + ", branchoffice=" + branchoffice + "]";
	};	
}
