package com.sumeru.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.sumeru.utils.IConstants;

@MappedSuperclass
public class BaseCarRentalObject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Version
    @Column(name = "version")
    private int version = 0;

	@Column(name = "status")
	private String status =  IConstants.STATUS_ACTIVE; 
	
	@Column(name = "note")
	//@Lob
	private String note; 
	
	@Column(name = "lastUpdatedBy")
	private String lastUpdatedBy; 
	
	@Column(name = "cityName")
	private String cityName; 
	
//	@Column(name = "lastUpdatedOn" )
//	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
//	private LocalDateTime lastUpdatedOn; 
//	
	@Column(name = "lastUpdatedOn", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdatedOn;
	
	public BaseCarRentalObject() {
		super();
	}

	public long getId() {
		return id;
	}

//	public void setId(long id) {
//		this.id = id;
//	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	
	public Date getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Date lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getVersion() {
		return version;
	}

	@SuppressWarnings("unused")
	private void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "BaseCarRentalObject [id=" + id + ", version=" + version
				+ ", status=" + status + ", note=" + note + ", lastUpdatedBy="
				+ lastUpdatedBy + ", cityName=" + cityName + "]";
	}

	
	
	

}
