package com.webservice.IeltsWeb.Model;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.IeltsWeb.jpa.AccountRespository;
import com.webservice.IeltsWeb.jpa.CartResponsitory;
import com.webservice.IeltsWeb.jpa.CommentResponsitory;
import com.webservice.IeltsWeb.jpa.CourseResponsitory;
import com.webservice.IeltsWeb.jpa.ForumResponsitory;

import jakarta.validation.Valid;

@RestController
public class CommentJpaResource {
	
	private CommentResponsitory respository;
	private AccountRespository accountRespository;
	private ForumResponsitory forumResponsitory;

	public CommentJpaResource(CommentResponsitory respository,AccountRespository accountRespository, ForumResponsitory forumResponsitory) {
		super();
		this.respository = respository;
		this.accountRespository = accountRespository;
		this.forumResponsitory = forumResponsitory;
	}
	
	
	@GetMapping("/comment")
	public java.util.List<Comment> GetALL(){
		return respository.findAll();	
		
	}
	
	@GetMapping("/fcmt/{id}")
	public Set<Comment> getCommentInforum(@PathVariable String id){
		
		Account user =  accountRespository.findById(id).get();
    	if(user == null) {
    		throw new UserNotFoundException("id 1111 "+id);
    		
    	}
    	return user.getMyComment();
    		
	}
	
	@PostMapping("/addComment")
	public void CreateComment(@Valid @RequestBody Comment comment ) {
		 
//	    cart.setCID(courseResponsitory.findById(cart.getCourseId()).get());
//	    cart.setUser(accountRespository.findById(cart.getUserId()).get());   
	   //comment.setForumID(forumResponsitory.findById(comment.getFID()).get());
	   comment.setiDAccount(accountRespository.findById(comment.getID()).get());
	   comment.setForumID(forumResponsitory.findById(comment.getFID()).get());
       respository.save(comment);
		
	}
	
	

}
