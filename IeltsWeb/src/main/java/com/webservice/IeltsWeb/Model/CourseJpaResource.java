package com.webservice.IeltsWeb.Model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.webservice.IeltsWeb.jpa.AccountRespository;
import com.webservice.IeltsWeb.jpa.CartResponsitory;
import com.webservice.IeltsWeb.jpa.CourseResponsitory;

import jakarta.validation.Valid;
import java.util.ArrayList;



@RestController
public class CourseJpaResource {
	
	private CourseResponsitory respository;
	private AccountRespository accountResource;
	private CartResponsitory cartResponsitory;

	public CourseJpaResource(CourseResponsitory respository,AccountRespository accountResource, CartResponsitory cartResponsitory) {
		super();
		this.respository = respository;
		this.accountResource = accountResource;
		this.cartResponsitory = cartResponsitory;
	}
	
	@GetMapping("/course")
	public ResponseEntity<List<CourseDTO>> getCourses() {
     
		List<Course> courses = respository.findAll();
		 
	    List<CourseDTO> courseDTOs = new ArrayList<>();
	    
		for (Course course : courses) {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setCID(course.getCID());
            courseDTO.setCOURESENAME(course.getName());
            courseDTO.setCATEGORY(course.getCategory());
            courseDTO.setDESCRIPTION(course.getDescription());
            courseDTO.setPRICE(course.getPrice());
            courseDTO.setIMG(course.getImg());
            courseDTO.setOWNERNAME(accountResource.findById(course.getOwner().getiDString()).get().getNameString());
            
            courseDTOs.add(courseDTO);
        }

        return ResponseEntity.ok(courseDTOs);
	
		
	}
	
	@GetMapping("/inforcourse/{id}")
	public ResponseEntity<CourseDTO> getInfoCourse(@PathVariable String id){
		
		Course course = respository.findById(id).get();
		CourseDTO courseDTO = new CourseDTO();
        courseDTO.setCID(course.getCID());
        courseDTO.setCOURESENAME(course.getName());
        courseDTO.setCATEGORY(course.getCategory());
        courseDTO.setDESCRIPTION(course.getDescription());
        courseDTO.setPRICE(course.getPrice());
        courseDTO.setIMG(course.getImg());
        courseDTO.setOWNERNAME(accountResource.findById(course.getOwner().getiDString()).get().getNameString());
        return ResponseEntity.ok(courseDTO);
	}
	
	@GetMapping("/course/{id}")
	public Set<Lesson> getLessonOfCourse(@PathVariable String id){
		
		Course course = respository.findById(id).get();
		
        return course.getListLessons();
	}
	
	@GetMapping("/mycourse/{id}")
	public ResponseEntity<List<ExtendedIfo>> getMyCourse(@PathVariable String id){
		
		
		List<Cart> carts = cartResponsitory.findAll();
		List<ExtendedIfo> list = new ArrayList<>();
		for (Cart cart: carts) {
			if(cart.getUserId().equals(id) && cart.isStatus()) {
				ExtendedIfo courseExtend= new ExtendedIfo();
				Course course = respository.findById(cart.getCourseId()).get();
				courseExtend.setCID(course.getCID());
				courseExtend.setCOURESENAME(course.getName());
				courseExtend.setCATEGORY(course.getCategory());
				courseExtend.setDESCRIPTION(course.getDescription());
				courseExtend.setPRICE(course.getPrice());
				courseExtend.setIMG(course.getImg());
				courseExtend.setOWNERNAME(accountResource.findById(course.getOwner().getiDString()).get().getNameString());
				courseExtend.setAdditionalVariable(course.getOwner().getiDString());
				
				list.add(courseExtend);
			}
		}
		
        return ResponseEntity.ok(list);
	}
	
	@GetMapping("/mycart/{id}")
	public ResponseEntity<List<ExtendedIfo>> getMyCart(@PathVariable String id){
		
		
		List<Cart> carts = cartResponsitory.findAll();
		List<ExtendedIfo> list = new ArrayList<>();
		for (Cart cart: carts) {
			if(cart.getUserId().equals(id) && !cart.isStatus()) {
				ExtendedIfo courseExtend= new ExtendedIfo();
				Course course = respository.findById(cart.getCourseId()).get();
				courseExtend.setCID(course.getCID());
				courseExtend.setCOURESENAME(course.getName());
				courseExtend.setCATEGORY(course.getCategory());
				courseExtend.setDESCRIPTION(course.getDescription());
				courseExtend.setPRICE(course.getPrice());
				courseExtend.setIMG(course.getImg());
				courseExtend.setOWNERNAME(accountResource.findById(course.getOwner().getiDString()).get().getNameString());
				courseExtend.setAdditionalVariable(course.getOwner().getiDString());
				
				list.add(courseExtend);
			}
		}
		
        return ResponseEntity.ok(list);
	}
	

	@GetMapping("/myclass/{id}")
	public ResponseEntity<List<ExtendedIfo>> getMyClass(@PathVariable String id){
		
		
		List<Course> courses = respository.findAll();
		List<ExtendedIfo> list = new ArrayList<>();
		for (Course course: courses) {
			if(course.getOwner().getiDString().equals(id)) {
				ExtendedIfo courseExtend= new ExtendedIfo();
				courseExtend.setCID(course.getCID());
				courseExtend.setCOURESENAME(course.getName());
				courseExtend.setCATEGORY(course.getCategory());
				courseExtend.setDESCRIPTION(course.getDescription());
				courseExtend.setPRICE(course.getPrice());
				courseExtend.setIMG(course.getImg());
				courseExtend.setOWNERNAME(accountResource.findById(course.getOwner().getiDString()).get().getNameString());
				courseExtend.setAdditionalVariable(course.getOwner().getiDString());
				
				list.add(courseExtend);
			}
		}
		
        return ResponseEntity.ok(list);
	}
	
    
	
	
	@PostMapping("/addcourse")
	public void CreateCourse(@Valid @RequestBody Course course ) {
		
		course.setOwner(accountResource.findById(course.getOwnerID()).get());
		respository.save(course);
		
		
	}
	
	@PutMapping("/updatecourse")
	public void UpDatecourse(@Valid @RequestBody Course course ) {
		
		if(accountResource.findById(course.getOwnerID()).get() == null) {
			throw new UserNotFoundException("null");
		}
		course.setOwner(accountResource.findById(course.getOwnerID()).get());
		respository.save(course);
		
		
	}
	
	@DeleteMapping("/deletecourse/{id}")
    public void UpDatecourse(@PathVariable String id ) {
		respository.deleteById(id);
	}
	
	
	
	

}
