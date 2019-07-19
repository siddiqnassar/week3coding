package com.sapient.employee.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Post")
@Data
public class Post implements Serializable{
	private static final int serialVersionUID = 1;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	private String title;
    private String body;
    @Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + "]";
	}
public Post()
{    
	
}
}
