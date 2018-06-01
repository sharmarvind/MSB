package com.mbs.bsp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name ="merchants")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"PaymentPassword", "TimesheetPassword", "password", "accountNonExpired"}, allowGetters = true)
public class Merchant implements Serializable, UserDetails {
	static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public long getId() {
  return id;}

  public void setId(Long id) {
  this.id = id;}

  @NotBlank
	private String firstname;
	
	@NotBlank	
	private String lastname;
	
	@NumberFormat
	private Integer mobile;
	
	@NotBlank
	@Column(name="paymentPassword")
	private String paymentPassword;
	
	@NotBlank
	private boolean enabled;
	
	@OneToMany(mappedBy="merchant", cascade = CascadeType.ALL)
	private Set<Client> clients = new HashSet<Client>();
	
	Merchant() {
    
	}
	
	public void setClients(Set<Client> client) {
		this.clients = client;
		
	}
	
	public Set<Client> getClient(){
		return this.clients;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
	
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
	
		return true;
	}
	
	@Override
	public String getPassword() {
		return paymentPassword;
	}
	
	@Override
	public String getUsername() {
	return Integer.toString(mobile);
	}
	
	@Override
	public boolean isEnabled() {
	
		return enabled;
	}
	
	public String getFirstname (){
		return this.firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname (){
		return this.lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setMobile(int mob) {
		this.mobile = mob;
	}
	
	public int getMobile (){
		return this.mobile;
	}
	
	

}
