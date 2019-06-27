package com.docplexus.Tokendemo.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TokenInfo")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Token implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "tokenNumber")
	private long tokenNumber;

	@Column(name = "customerid")
	private long customerid;

	@Column(name = "creationDate")
	private Date creationDate;

	@Column(name = "counterNumber")
	private int counterNumber;

	@Column(name = "status")
	private String status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getTokenNumber() {
		return tokenNumber;
	}

	public void setTokenNumber(long tokenNumber) {
		this.tokenNumber = tokenNumber;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getCounterNumber() {
		return counterNumber;
	}

	public void setCounterNumber(int counterNumber) {
		this.counterNumber = counterNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Token [id=" + id + ", tokenNumber=" + tokenNumber + ", customerid=" + customerid + ", creationDate="
				+ creationDate + ", counterNumber=" + counterNumber + ", status=" + status + "]";
	}

}
