package com.mbs.bsp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.SQLInsert;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="packages")
@EntityListeners(AuditingEntityListener.class)
public class Packages implements Serializable {
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public int getId() {
  return id;}

  public void setId(int id) {
  this.id = id;}
  


public String getName() {
  return name;}
  
  public void setName(String name) {
  this.name = name;}

  public int getFrequency() {
  return frequency;}

  public void setFrequency(int frequency) {
  this.frequency = frequency;}

  public int getPrice() {
  return price;}

  public void setPrice(int price) {
  this.price = price;}
  
  @Column(name="merchant_id", nullable=false)
  private int merchant_id;
  public int getMerchant_id() {
  return merchant_id;}

  public void setMerchant_id(int mc_id) {
  this.merchant_id = mc_id;}

  @NotBlank
	private String name;
	
	@NotNull
	private Integer frequency;
	
	@NotNull(message="Price is Required")
	private Integer price;
	
	@ManyToOne
	@JoinColumn(name="merchant_id", insertable=false, updatable=false)
	@JsonBackReference
	private Merchant merchant;
	
}
