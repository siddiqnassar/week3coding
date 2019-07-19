package com.sapient.employee.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlRootElement
@Entity
@Table
@XmlAccessorType(XmlAccessType.FIELD)
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
	@Column
	private int id;

	@Column
	private String name;

	@Column
	private String email;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private Address address;
	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="post")
    private List<Post> posts;
	public User()
	{
		
	}
	public User(String name, String email) {
	
		this.name = name;
		this.email = email;
	}
	
	
	public int getId() {
		return id;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public Address getAddress() {
		return address;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress(Address address)
	{
		return address;
	}
	public void setAddress(Address adrress)
	{
		this.address=address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", posts=" + posts
				+ "]";
	}
}
