package com.webservice.IeltsWeb.Model;

import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.IeltsWeb.jpa.AccountRespository;
import com.webservice.IeltsWeb.jpa.CartResponsitory;
import com.webservice.IeltsWeb.jpa.CommentResponsitory;
import com.webservice.IeltsWeb.jpa.CourseResponsitory;
import com.webservice.IeltsWeb.jpa.ForumResponsitory;
import com.webservice.IeltsWeb.jpa.LessonResponsitory;

import jakarta.validation.Valid;

@RestController
public class LessonJpaResource {
	
	private LessonResponsitory respository;
	private CourseResponsitory courseResponsitory;

	public LessonJpaResource(LessonResponsitory respository,CourseResponsitory courseRespository) {
		super();
		this.respository = respository;
		this.courseResponsitory = courseRespository;
		
	}
	
	
	@GetMapping("/Lesson")
	public java.util.List<Lesson> GetALL(){
		return respository.findAll();	
		
	}
	
//	@GetMapping("/comment/{id}")
//	public Set<Comment> getMyCarts(@PathVariable String id){
//		
//		Account user =  accountRespository.findById(id).get();
//    	if(user == null) {
//    		throw new UserNotFoundException("id 1111 "+id);
//    		
//    	}
//    	return user.getMyComment();
//    		
//}
	
	@PostMapping("/addlesson")
	public void CreateLesson(@Valid @RequestBody Lesson lesson ) {
		
       lesson.setCourseId(courseResponsitory.findById(lesson.getCID()).get());
       respository.save(lesson);
		
	}
	
	@PutMapping("/updatelesson")
	public void updatelesson(@Valid @RequestBody Lesson lesson ) {
		
       lesson.setCourseId(courseResponsitory.findById(lesson.getCID()).get());
       respository.save(lesson);
		
	}
	
	@DeleteMapping("/deletelsesson/{id}")
	public void deletelesson(@PathVariable String id) {
		respository.deleteById(id);
	}
	
	
	
	
	

}
