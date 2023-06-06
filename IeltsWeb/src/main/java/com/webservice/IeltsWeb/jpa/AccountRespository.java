package com.webservice.IeltsWeb.jpa;

import org.springframework.data.jpa.repository.JpaRepository;


import com.webservice.IeltsWeb.Model.Account;

public interface AccountRespository extends JpaRepository<Account,String>{
	
	

}
