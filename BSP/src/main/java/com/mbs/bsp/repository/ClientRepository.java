package com.mbs.bsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.bsp.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	List<Client> findByMerchantIdOrderByFirstnameAsc(Long merchantId);
}
