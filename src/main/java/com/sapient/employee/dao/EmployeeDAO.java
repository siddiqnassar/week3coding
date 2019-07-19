package com.sapient.employee.dao;

import java.util.List;

import com.sapient.employee.model.Post;
import com.sapient.employee.model.User;


public interface EmployeeDAO {
	
	public User saveEmployee(User user);

    public List<User> fetchAllEmployees();

    public User findById(int id);

    public void deleteEmployee(int id);


	void updateEmployee(int id,User user);

	public Post getPostByid(int id,int postid);

	 public Post createPost(int id, Post post);

	void deleteAllPostsById(int id);
	void deletePostById(int id,int postid);

	List<Post> getAllPosts(int id);

}


	
    

