package com.license.Szerviz.Entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Car")
@Table(name = "cars", catalog = "postgres", schema = "public")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "brandsid")
	private Integer brandsid;
	
	@Column(name = "modelsid")
	private Integer modelsid;
	
	@Column(name = "licensenumber")
	private String licenseNumber;

	@Column(name = "chassisnr", unique = true)
	private String chassisnr;
	
	@Column(name = "enginenr")
	private String enginenr;
	
	@Column(name = "milometer")
	private Integer milometer;
	
	@Column(name = "year")
	private Integer year;
	
	@Column(name = "ownernr")
	private Integer ownernr;
	
	@Column(name = "seatnr")
	private Integer seatnr;
	
	@Column(name = "firstregdate")
	private Date firstregdate;
	
	@Column(name = "warrantydate")
	private Date warrantydate;
	
	@Column(name = "warrantykm")
	private Integer warrantykm;
	
	@Column(name = "validityfrom")
	private Date validityfrom;
	
	@Column(name = "validityto")
	private Date validityto;
	
	@Column(name = "lastverificationdate")
	private Date lastverificationdate;
	
	@Column(name = "tiredimension")
	private String tiredimension;
	
	@Column(name = "carbody")
	private String carbody;
	
    @OneToMany(mappedBy="cars")
    private Set<Registration> registrations;
    
	@OneToOne
	@JoinColumn(name = "brandsid", insertable = false, updatable = false)
	private Brand brands;
	
	@OneToOne
	@JoinColumn(name = "modelsid", insertable = false, updatable = false)
	private Model models;
	
	public Car() {
	}

	public Car(String licenseNumber, Integer brandsid, Integer modelsid, String chassisnr, String enginenr, Integer milometer) {
		this.licenseNumber = licenseNumber;
		this.brandsid = brandsid;
		this.modelsid = modelsid;
		this.chassisnr = chassisnr;
		this.enginenr = enginenr;
		this.milometer = milometer;
	}
	
	public Car(Integer brandsid, Integer modelsid, String licenseNumber, String chassisnr, String enginenr,
			Integer milometer, Integer year, Integer ownernr, Integer seatnr, Date firstregdate, Date warrantydate,
			Integer warrantykm, Date validityfrom, Date validityto, Date lastverificationdate, String tiredimension,
			String carbody) {
		this.brandsid = brandsid;
		this.modelsid = modelsid;
		this.licenseNumber = licenseNumber;
		this.chassisnr = chassisnr;
		this.enginenr = enginenr;
		this.milometer = milometer;
		this.year = year;
		this.ownernr = ownernr;
		this.seatnr = seatnr;
		this.firstregdate = firstregdate;
		this.warrantydate = warrantydate;
		this.warrantykm = warrantykm;
		this.validityfrom = validityfrom;
		this.validityto = validityto;
		this.lastverificationdate = lastverificationdate;
		this.tiredimension = tiredimension;
		this.carbody = carbody;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrandsid() {
		return brandsid;
	}

	public void setBrandsid(Integer brandsid) {
		this.brandsid = brandsid;
	}

	public Integer getModelsid() {
		return modelsid;
	}

	public void setModelsid(Integer modelsid) {
		this.modelsid = modelsid;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getChassisnr() {
		return chassisnr;
	}

	public void setChassisnr(String chassisnr) {
		this.chassisnr = chassisnr;
	}

	public String getEnginenr() {
		return enginenr;
	}

	public void setEnginenr(String enginenr) {
		this.enginenr = enginenr;
	}

	public Integer getMilometer() {
		return milometer;
	}

	public void setMilometer(Integer milometer) {
		this.milometer = milometer;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getOwnernr() {
		return ownernr;
	}

	public void setOwnernr(Integer ownernr) {
		this.ownernr = ownernr;
	}

	public Integer getSeatnr() {
		return seatnr;
	}

	public void setSeatnr(Integer seatnr) {
		this.seatnr = seatnr;
	}

	public Date getFirstregdate() {
		return firstregdate;
	}

	public void setFirstregdate(Date firstregdate) {
		this.firstregdate = firstregdate;
	}

	public Date getWarrantydate() {
		return warrantydate;
	}

	public void setWarrantydate(Date warrantydate) {
		this.warrantydate = warrantydate;
	}

	public Integer getWarrantykm() {
		return warrantykm;
	}

	public void setWarrantykm(Integer warrantykm) {
		this.warrantykm = warrantykm;
	}

	public Date getValidityfrom() {
		return validityfrom;
	}

	public void setValidityfrom(Date validityfrom) {
		this.validityfrom = validityfrom;
	}

	public Date getValidityto() {
		return validityto;
	}

	public void setValidityto(Date validityto) {
		this.validityto = validityto;
	}

	public Date getLastverificationdate() {
		return lastverificationdate;
	}

	public void setLastverificationdate(Date lastverificationdate) {
		this.lastverificationdate = lastverificationdate;
	}

	public String getTiredimension() {
		return tiredimension;
	}

	public void setTiredimension(String tiredimension) {
		this.tiredimension = tiredimension;
	}

	public String getCarbody() {
		return carbody;
	}

	public void setCarbody(String carbody) {
		this.carbody = carbody;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	public Brand getBrands() {
		return brands;
	}
	

	public void setBrands(Brand brands) {
		this.brands = brands;
	}
	

	public Model getModels() {
		return models;
	}
	

	public void setModels(Model models) {
		this.models = models;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", brandsid=" + brandsid + ", modelsid=" + modelsid + ", licenseNumber="
				+ licenseNumber + ", chassisnr=" + chassisnr + ", enginenr=" + enginenr + ", milometer=" + milometer
				+ ", year=" + year + ", ownernr=" + ownernr + ", seatnr=" + seatnr + ", firstregdate=" + firstregdate
				+ ", warrantydate=" + warrantydate + ", warrantykm=" + warrantykm + ", validityfrom=" + validityfrom
				+ ", validityto=" + validityto + ", lastverificationdate=" + lastverificationdate + ", tiredimension="
				+ tiredimension + ", carbody=" + carbody + "]";
	}
}
