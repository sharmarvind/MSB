package com.mbs.bsp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbs.bsp.model.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long>{
	Merchant findOneByMobile(int mobile);
	
	
}
