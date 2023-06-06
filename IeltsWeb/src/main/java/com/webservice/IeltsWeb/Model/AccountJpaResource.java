package com.webservice.IeltsWeb.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.IeltsWeb.jpa.AccountRespository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertFalse.List;


@RestController
public class AccountJpaResource {
	
	private AccountRespository respository;

	public AccountJpaResource(AccountRespository respository) {
		super();
		this.respository = respository;
	}
	
	
	@GetMapping("/account")
	public java.util.List<Account> GetALL(){
		return respository.findAll();	
		
	}
	
	@PostMapping("/account")
	public void CreateAccount( @Valid @RequestBody Account account ) {
		
		respository.save(account);
		
	}
	
	

}
