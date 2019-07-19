package com.sapient.employee.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.employee.dao.EmployeeDAO;
import com.sapient.employee.model.Post;
import com.sapient.employee.model.User;

@Service(value = "employeeService")

public class EmployeeServiceImpl implements EmployeeService{

	 @Autowired( required = true)
	 @Qualifier(value = "hibernateDAOImpl")
	 private EmployeeDAO employeeDao;
	
	 public EmployeeServiceImpl(@Qualifier(value = "hibernateDAOImpl") EmployeeDAO employeeDao){
     this.employeeDao=employeeDao;
 }
	 @Transactional
	public User saveEmployee(User user) {
		System.out.println("Inside the save employee method of Employee service class ....");
        return employeeDao.saveEmployee(user);
		
	}

	 @Transactional
	public List<User> fetchAllEmployees() {
	
		return employeeDao.fetchAllEmployees();
	}
	 @Transactional
	public User findById(int id) {
		return employeeDao.findById(id);
	}

	 @Transactional
	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
		
	}

	 @Transactional
	public void updateEmployee(int id, User user) {
		 employeeDao.updateEmployee(id,user);
	}
	
	
	 @Transactional
	public Post getPostByid(int id, int postid) {
		// TODO Auto-generated method stub
		return employeeDao.getPostByid(id, postid);
	}
	 @Transactional
	public Post createPost(int id, Post post) {
		// TODO Auto-generated method stub
		return employeeDao.createPost(id, post);
	}
	 @Transactional
	public void deleteAllPostsById(int id) {
		// TODO Auto-generated method stub
		employeeDao.deleteAllPostsById(id);
		
	}
	 @Transactional
	public List<Post> getAllPosts(int id) {
		// TODO Auto-generated method stub
		System.out.println("hi");
		return employeeDao.getAllPosts(id);
	}
	 @Transactional
	public void deletePostById(int id,int postid) {
		// TODO Auto-generated method stub
		
		employeeDao.deletePostById(id,postid);
		
	}
	

}
