package com.mbs.bsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mbs.bsp.repository.MerchantRepository;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
	
	@Autowired
	private MerchantRepository merchantRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return merchantRepo.findOneByMobile(Integer.parseInt(username));
		
	}
	
	
	
}
