package com.mbs.bsp.controller;

import java.security.Principal;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bsp.model.Merchant;
import com.mbs.bsp.model.Packages;
import com.mbs.bsp.repository.MerchantRepository;
import com.mbs.bsp.repository.PackageRepository;

@RestController
@RequestMapping("/api")
public class PackageController {
	
	@Autowired
	PackageRepository packageRepo;
	
	@Autowired
	MerchantRepository merchantRepo;
	
	@GetMapping("/package")
	public List<Packages> getPackages(Principal principal) {
		Merchant merchant =  merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		return packageRepo.findByMerchantIdOrderByFrequency(merchant.getId());
	}
	
	@RequestMapping(value="/package", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded" , produces="application/json")
	public Packages addPackage(@ModelAttribute @Valid Packages packages, Principal principal) {
		Merchant merchant = merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		int id = (int) merchant.getId();
		packages.setMerchant_id(id);
		return packageRepo.save(packages);
	}
}
