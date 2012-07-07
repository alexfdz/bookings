package com.markit.bookings.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Booking {
	@EmbeddedId
	private BookingPK bookingPK;
	
	private String guest;
	
	public Booking(BookingPK bookingPK, String guest){
		this.bookingPK = bookingPK;
		this.guest = guest;
	}
	
	public BookingPK getBookingPK() {
		return bookingPK;
	}
	
	public void setBookingPK(BookingPK bookingPK) {
		this.bookingPK = bookingPK;
	}
	
	public String getGuest() {
		return guest;
	}
	
	public void setGuest(String guest) {
		this.guest = guest;
	}
}
