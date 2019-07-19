package com.sapient.employee.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.employee.model.Post;
import com.sapient.employee.model.User;
import com.sapient.employee.service.EmployeeService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@RestController
@RequestMapping("/api/v1/service")
public class UserController {

	@Autowired (required= true)
	@Qualifier(value="employeeService")
	private EmployeeService employeeService;
	
	@GetMapping(value="/",produces = {APPLICATION_JSON_VALUE })
	public List<User> listAll()
	{
		List<User> product=new ArrayList<User>();
    	product = employeeService.fetchAllEmployees();	
        return product;
	}
	@GetMapping(value = "/{id}",produces= {APPLICATION_JSON_VALUE})
	public User findById(@PathVariable("id") int id)
	{
		User user=new User();
		user=employeeService.findById(id);
        return user;
		
	}
	
	@PostMapping(value="/save",consumes= {APPLICATION_JSON_VALUE})
	 @ResponseStatus(HttpStatus.CREATED)
	public User saveEmployee(@RequestBody User user)
	{
		System.out.println(user);
		employeeService.saveEmployee(user);
		return user;
	}
	@PutMapping(value="/{id}",consumes={APPLICATION_JSON_VALUE})
	public void updateEmployee(@PathVariable("id") int id,@RequestBody User user)
	{
		user.setId(id);
		employeeService.updateEmployee(id, user);
		System.out.println("came inside update product");
	}

	
	@DeleteMapping(value="/delete/{id}", consumes= {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE})
	public void deleteEmployee(@PathVariable("id") int id)
	{
		employeeService.deleteEmployee(id);
		System.out.println("came inside delete product");
	}
	@GetMapping(value = "/{id}/posts", produces = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public List getAllPosts(@PathVariable("id") int id) {
		System.out.println("hi");
		List<Post> l = employeeService.getAllPosts(id);
		return l;
	}
	@GetMapping(value = "/{id}/posts/{postid}", produces = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public Post getPostById(@PathVariable("id") int id,@PathVariable("postid") int postid) {
	return	employeeService.getPostByid(id,postid);
		

	}
	@DeleteMapping(value = "/{id}/deletepost/{postid}", produces = {APPLICATION_JSON_VALUE,APPLICATION_XML_VALUE })
	@ResponseStatus(HttpStatus.OK)
	public void deletePostById(@PathVariable("id") int id,@PathVariable("postid") int postid) {
		 employeeService.deletePostById(id,postid);
		

	}
	@DeleteMapping(value = "/{id}/deletepost")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAllPosts(@PathVariable("id") int id) {
		 employeeService.deleteAllPostsById(id);
		

	}
	
	
	}
