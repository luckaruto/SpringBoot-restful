package com.webservice.IeltsWeb.Model;

import java.net.URI;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.webservice.IeltsWeb.jpa.AccountRespository;
import com.webservice.IeltsWeb.jpa.CartRespon;
import com.webservice.IeltsWeb.jpa.CartResponsitory;
import com.webservice.IeltsWeb.jpa.CourseResponsitory;

import jakarta.validation.Valid;

@RestController
public class CartJpaResource {
	
	private CartResponsitory respository;
	private AccountRespository accountRespository;
	private CourseResponsitory courseResponsitory;
	private CartRespon cartrespon;

	public CartJpaResource(CartResponsitory respository,AccountRespository accountRespository,
            CartRespon cartRespon,
			CourseResponsitory courseResponsitory) {
		super();
		this.respository = respository;
		this.accountRespository = accountRespository;
		this.courseResponsitory = courseResponsitory;
		this.cartrespon = cartRespon;
	}
	
	
	@GetMapping("/cart")
	public java.util.List<Cart> GetALL(){
		return respository.findAll();	
		
	}
	
	
	@PutMapping("/enrollcourse")
	public void enrollcourse(@Valid @RequestBody Cart cart ) {

	    cart.setCID(courseResponsitory.findById(cart.getCourseId()).get());
	    cart.setUser(accountRespository.findById(cart.getUserId()).get());
	    cart.setStatus(true);
	   
	    
		respository.save(cart);
		
	}
	
	@PostMapping("/addtocart")
	public void CreateAccount(@Valid @RequestBody Cart cart ) {
		 
	    cart.setCID(courseResponsitory.findById(cart.getCourseId()).get());
	    cart.setUser(accountRespository.findById(cart.getUserId()).get());
	    cart.setStatus(false);
		respository.save(cart);
		
	}
	
	@PostMapping("/deletefromcart")
	public ResponseEntity<String> DeleteItem(@Valid @RequestBody Cart cart) {
		
		CartId compositeKey = new CartId();
		compositeKey.setCId(cart.getCourseId());
		compositeKey.setId(cart.getUserId());
		System.out.println(compositeKey.getCId());
		System.out.println(compositeKey.getId());
		
	   
		
		respository.deleteByCourseIdAndUserId(cart.getCourseId(), cart.getUserId());
	    return  ResponseEntity.ok("okla");
	}
	

}
