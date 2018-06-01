package com.mbs.bsp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bsp.model.Merchant;
import com.mbs.bsp.repository.MerchantRepository;

@RestController
@RequestMapping("/api")
public class MerchantController {
	@Autowired
	MerchantRepository merchantRepo;
	
	/*
	 * Find All Merchant
	 */
	@GetMapping("/merchants")
	public List<Merchant> getAllMerchants() {
				
		return merchantRepo.findAll();
    
  }
	
	/*
	 * Create Merchant
	 */
	@PostMapping("/merchants")
	public Merchant addMerchant(@Valid @RequestBody Merchant merchant){
		return merchantRepo.save(merchant);		
	}
	
	/*
	 * Get Single Merchant
	 */
	
}
