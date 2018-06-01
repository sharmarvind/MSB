package com.mbs.bsp.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bsp.model.Client;
import com.mbs.bsp.model.Merchant;
import com.mbs.bsp.model.Packages;
import com.mbs.bsp.repository.ClientRepository;
import com.mbs.bsp.repository.MerchantRepository;
import com.mbs.bsp.repository.PackageRepository;

@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	MerchantRepository merchantRepo;
	
	@Autowired
	PackageRepository pkgRepo;
	
	
	@GetMapping("/client")
	public List<Client> getClients(Principal principal) {
		 Merchant merchant =  merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		 
		//principal.get
		return clientRepo.findByMerchantIdOrderByFirstnameAsc(merchant.getId());		
	}
	
	@RequestMapping(value="/client", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded" , produces="application/json")
	public Client addClient(@ModelAttribute @Valid Client client, Principal principal) {
		Merchant merchant = merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		int id = (int) merchant.getId();
		client.setMerchant_id(id);
		
		/*
		 * validate the marchant id with package id
		 */
		Packages pkg = pkgRepo.findOneByIdAndMerchantId(client.getPackage_id(), merchant.getId());
		if (null == pkg) {
			// set error
		}
		
		int amount = (pkg.getPrice()/pkg.getFrequency());
		
		/*
		 * Set Due Amount and insert Invoice item only if due date <= today
		 * else batch process will update it
		 */
		@SuppressWarnings("deprecation")
    Date dDate;
    try {
    	
      dDate = new SimpleDateFormat("yyyy-MM-dd").parse(client.getDuedate());
      if (dDate.getTime() <= new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString()).getTime() ) {
			client.setDueamount(0-amount);
		}
    } catch (ParseException e) {
      // TODO Auto-generated catch block
    e.printStackTrace();
    }
		
		
		
		
		
		/*
		 * Update due amount as per Frequency
		 */
		
		
		
		
		
		return clientRepo.save(client);
    
  }
}
