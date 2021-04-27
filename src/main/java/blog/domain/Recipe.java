package blog.domain;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private int id;
	private String name;
	private int time;
	private String type;
	private Instant publishedOn = Instant.now();
	public Recipe() {
		super();
		
	}
	
	
	public Recipe(String name, int time, String type) {
		super();
		this.name = name;
		this.time = time;
		this.type = type;
	}


	public int getId() {
		return id;
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Instant getPublishedOn() {
		return publishedOn;
	}
	public void setPublishedOn(Instant publishedOn) {
		this.publishedOn = publishedOn;
	}
	

	
	
	
}