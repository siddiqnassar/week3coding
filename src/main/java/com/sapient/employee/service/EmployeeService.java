package com.sapient.employee.service;

import java.util.List;

import com.sapient.employee.model.Post;
import com.sapient.employee.model.User;

public interface EmployeeService {

	public User saveEmployee(User user);

    public List<User> fetchAllEmployees();

    public User findById(int id);

    public void deleteEmployee(int id);


	void updateEmployee(int id,User user);

	

	Post getPostByid(int id,int postid);
	void deletePostById(int id,int postid);
	

	Post createPost(int id, Post post);

	void deleteAllPostsById(int id);

	List<Post> getAllPosts(int id);

}
