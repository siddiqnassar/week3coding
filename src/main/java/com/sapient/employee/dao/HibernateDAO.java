package com.sapient.employee.dao;

import java.util.List;
import java.util.ListIterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.employee.model.Post;
import com.sapient.employee.model.User;


@Repository("hibernateDAOImpl")
public class HibernateDAO implements EmployeeDAO {

	@Autowired
    private SessionFactory sessionFactory;
	

	public User saveEmployee(User user) {
		
		System.out.println(user);
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        return user;
	}


	public List<User> fetchAllEmployees() {
		 Session currentSession = sessionFactory.getCurrentSession();
	        return currentSession.createQuery("from User").list();
		
	}

	public User findById(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}


	public void deleteEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
		
	}



	


	public void updateEmployee(int id, User user) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		System.out.print(user.getId());
        User user1 = session.byId(User.class).load(user.getId());
       
        user1.setName(user.getName());
      
        session.update(user1);
	}

	public Post getPostByid(int id, int postid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
       ListIterator<Post> li=posts.listIterator();
       while(li.hasNext())
       {
    	   Post p1=li.next();
    	   if(p1.getId()==postid)
    	   {
    		   return p1;
    	   }
    	   
       }
		return null;
	}


	public Post createPost(int id, Post post) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
        List<Post> posts=user1.getPosts();
        posts.add(post);
        user1.setPosts(posts);
        session.save(user1);
        return post;
	}


	public void deleteAllPostsById(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
     posts.clear();
     user1.setPosts(posts);
     session.save(user1);
	}


	public List<Post> getAllPosts(int id) {
		System.out.println("hi");
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
      return posts;
	}


	public void deletePostById(int id,int postid) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
        User user1 = session.byId(User.class).load(id);
       List<Post> posts=user1.getPosts();
      
       for(Post p:posts)
       {
    	   if(p.getId()==postid)
    	   {
    		   posts.remove(p);
    		   session.delete(p);
    		   break;
    	   }
       }
       user1.setPosts(posts);
       session.save(user1);
     
		
	}
	}

	

	
