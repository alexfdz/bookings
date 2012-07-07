package com.markit.bookings.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {

	private Integer id;
	
	public Room(){
	}
	
	public Room(Integer id){
		this.id = id;
	}
	
	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
