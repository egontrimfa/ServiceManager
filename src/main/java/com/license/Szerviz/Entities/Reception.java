package com.license.Szerviz.Entities;

import java.util.Date;
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

@Entity(name="Reception")
@Table(name="receptions", catalog="postgres", schema="public")
public class Reception {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="clientsid")
	private int clientsid;
    
	@Column(name="incominginvoicenr")
	private String incominginvoicenr;
	
	@Column(name="datein")
	private Date datein;
	
	@Column(name="duedate")
	private Date duedate;
	
    @ManyToOne
    @JoinColumn(name="clientsid", insertable = false, updatable = false)
    private Client clients;
    
    @OneToMany(mappedBy="receptions")
    private Set<Receptions_auto_pieces> receptions_auto_pieces;

	public Reception() {
	}

	public Reception(int clientsid, String incominginvoicenr, Date datein, Date duedate) {
		this.clientsid = clientsid;
		this.incominginvoicenr = incominginvoicenr;
		this.datein = datein;
		this.duedate = duedate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientsid() {
		return clientsid;
	}

	public void setClients(Client clients) {
		this.clients = clients;
	}

	public String getIncominginvoicenr() {
		return incominginvoicenr;
	}

	public void setIncominginvoicenr(String incominginvoicenr) {
		this.incominginvoicenr = incominginvoicenr;
	}

	public Date getDatein() {
		return datein;
	}

	public void setDatein(Date datein) {
		this.datein = datein;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public void setClientsid(int clientsid) {
		this.clientsid = clientsid;
	}

	public Client getClients() {
		return clients;
	}
	
	public Set<Receptions_auto_pieces> getReceptions_auto_pieces() {
		return receptions_auto_pieces;
	}

	public void setReceptions_auto_pieces(Set<Receptions_auto_pieces> receptions_auto_pieces) {
		this.receptions_auto_pieces = receptions_auto_pieces;
	}

	@Override
	public String toString() {
		return "Reception [id=" + id + ", clientsid=" + clientsid + ", incominginvoicenr=" + incominginvoicenr
				+ ", datein=" + datein + ", duedate=" + duedate + "]";
	}
}
