package com.webservice.IeltsWeb.Model;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.IeltsWeb.jpa.AccountRespository;
import com.webservice.IeltsWeb.jpa.ForumResponsitory;

import jakarta.validation.Valid;

@RestController
public class ForumJpaResource {
	
	private ForumResponsitory respository;
	private AccountRespository accountRespository;

	public ForumJpaResource(ForumResponsitory respository,AccountRespository accountRespository) {
		super();
		this.respository = respository;
		this.accountRespository = accountRespository;
		
	}
	
	
	@GetMapping("/forum")
	public java.util.List<Forum> GetALL(){
		return respository.findAll();	
		
	}
	
	@GetMapping("/form/{id}")
	public Set<Forum> getMyForum(@PathVariable String id){
		
		Account user =  accountRespository.findById(id).get();
    	if(user == null) {
    		throw new UserNotFoundException("id 1111 "+id);
    		
    	}
    	return user.getListForum();
    		
	}
	
	@PostMapping("/addForum")
	public void CreateForum(@Valid @RequestBody Forum forum ) {
		 forum.setID(accountRespository.findById(forum.getIDuser()).get());
		 //System.out.println(forum.toString());
		 respository.save(forum);
	   
	}
	
	

}
