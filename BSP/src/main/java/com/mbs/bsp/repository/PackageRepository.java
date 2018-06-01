package com.mbs.bsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.bsp.model.Packages;

public interface PackageRepository extends JpaRepository<Packages, Long>{
	List<Packages> findByMerchantIdOrderByFrequency(Long id);
	Packages findOneByIdAndMerchantId(int id, long merchantId);
}
