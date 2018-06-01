package com.mbs.bsp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="clients")
@EntityListeners(AuditingEntityListener.class)
public class Client implements Serializable {
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	
	//private Long merchant_id;
	
	@NotBlank
	private String firstname;
	
	@NotBlank
	private String lastname;
	
	

	@NumberFormat
	private int	mobile;
	
	@Email
	private String emailid;
	
	
	private String	address;
	
	@DateTimeFormat	
	private String duedate;
	
	@NumberFormat
	  private int dueamount;

	  public int getDueamount() {
	return dueamount;}

	public void setDueamount(int dueamount) {
	this.dueamount = dueamount;}
	

	@JsonIgnore
  @Column(name="merchant_id")
	private int merchant_id;
  
	public int getMerchant_id() {
		  return merchant_id;}

		  public void setMerchant_id(int merchant_id) {
		  this.merchant_id = merchant_id;}
	
	@Column(name="package_id")
	private int package_id;
	
	public int getPackage_id() {
  return package_id;}

  public void setPackage_id(int package_id) {
  this.package_id = package_id;}

  @ManyToOne
	@JoinColumn(name="package_id", insertable=false, updatable=false)
	@JsonBackReference
	private Packages packageDetails;
	
	@ManyToOne
	@JoinColumn(name="merchant_id",insertable=false, updatable=false)
	@JsonBackReference
	private Merchant merchant;
	
	public String getFirstname() {
		  return firstname;
		  }

		  public void setFirstname(String firstname) {
		  this.firstname = firstname;}

		  public String getLastname() {
		  return lastname;}

		  public void setLastname(String lastname) {
		  this.lastname = lastname;}

		  public int getMobile() {
		  return mobile;}

		  public void setMobile(int mobile) {
		  this.mobile = mobile;}

		  public String getEmailid() {
		  return emailid;}

		  public void setEmailid(String emailid) {
		  this.emailid = emailid;}

		  public String getAddress() {
		  return address;}

		  public void setAddress(String address) {
		  this.address = address;}

		  public String getDuedate() {
		  return duedate;}

		  public void setDuedate(String duedate) {
		  this.duedate = duedate;}
}
