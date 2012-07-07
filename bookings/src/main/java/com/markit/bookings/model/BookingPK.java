package com.markit.bookings.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class BookingPK implements Serializable{
	private static final long serialVersionUID = 1L;
	@ManyToOne
	private Room room;
	private Date date;
	
	public BookingPK(){
	}
	
	public BookingPK(Room room, Date date){
		this.room = room;
		this.date = date;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
