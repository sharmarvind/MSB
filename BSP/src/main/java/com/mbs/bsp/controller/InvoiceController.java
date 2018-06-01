package com.mbs.bsp.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bsp.model.Client;
import com.mbs.bsp.model.Invoice;
import com.mbs.bsp.model.Merchant;
import com.mbs.bsp.model.Packages;
import com.mbs.bsp.repository.ClientRepository;
import com.mbs.bsp.repository.InvoiceRepository;
import com.mbs.bsp.repository.MerchantRepository;

@RestController
@RequestMapping("/api")
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepo;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private MerchantRepository merchantRepo;
	
	@GetMapping("/invoice/{clientId}")
	public List<Invoice> getInvoice(@PathVariable int clientId, Principal principal) {
		Merchant merchant = merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		return invoiceRepo.findByClientIdAndMerchantIdOrderByCreated(clientId,  (int) merchant.getId());
	}
	
	//@Transactional
	@RequestMapping(value="/invoice", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded" , produces="application/json")
	public Invoice makePayment(@ModelAttribute @Valid Invoice invoice,Principal principal) {
	
		/*
		 * Add check for Amount to be > 0
		 */
		
		Merchant merchant = merchantRepo.findOneByMobile(Integer.parseInt(principal.getName()));
		int id = (int) merchant.getId();
		invoice.setMerchantId(id);
		invoice.setCreated(LocalDate.now().toString());
		invoice.setReportDate(LocalDate.now().toString());
		invoice.setType(Invoice.invoiceType.PAYMENT.toString());
		
		Client client = clientRepo.findOne((long)invoice.getClientId());
		client.setDueamount(client.getDueamount() + invoice.getAmount());
		
		return invoiceRepo.save(invoice);
	}
	
	@RequestMapping(value="/bulkinvoice", method=RequestMethod.POST, consumes="application/x-www-form-urlencoded" , produces="application/json")
	public int createBulkInvoice(Principal principal) {
		/*
		 * It will fetch all client for merchant and genrate the Invoices
		 */
		return 0;
	}
}
