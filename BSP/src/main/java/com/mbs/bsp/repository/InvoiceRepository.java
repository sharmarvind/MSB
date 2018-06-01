package com.mbs.bsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbs.bsp.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
	List<Invoice> findByClientIdAndMerchantIdOrderByCreated(int clientId, int merchantId);
}
