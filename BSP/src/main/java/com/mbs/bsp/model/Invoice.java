package com.mbs.bsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="invoice")
@EntityListeners(AuditingEntityListener.class)
public class Invoice implements Serializable {
	public Long getId() {
  return Id;}

  public void setId(Long id) {
  Id = id;}

  public int getClientId() {
  return clientId;}

  public void setClientId(int clientId) {
  this.clientId = clientId;}

  public int getMerchantId() {
  return merchantId;}

  public void setMerchantId(int merchantId) {
  this.merchantId = merchantId;}

  public String getCreated() {
  return created;}

  public void setCreated(String created) {
  this.created = created;}

  public String getReportDate() {
  return ReportDate;}

  public void setReportDate(String reportDate) {
  ReportDate = reportDate;}

  public int getAmount() {
  return amount;}

  public void setAmount(int amount) {
  this.amount = amount;}

  public String getType() {
  return type;}

  public void setType(String type) {
  this.type = type;}

  static final long serialVersionUID = 1L;
	
	public enum invoiceType {
		BILL,
		PAYMENT
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@NotNull
	@Column(name="client_id", nullable=false)
	private int clientId;
	
	
	@JsonIgnore
	private int merchantId;
	
	
	private String created;
	
	@Column(name="Report_date")
	private String ReportDate;
	
	@NotNull
	private int amount;
	
	
	private String type;
	
}
