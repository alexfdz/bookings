package com.markit.bookings.bo;

import java.util.Date;
import java.util.List;

public interface BookingManager {

	/**
	* Return true if there is no booking for the given room on the date,
	* otherwise false
	*/
	public boolean isRoomAvailable(Integer room, Date date);

	/**
	* Add a booking for the given guest in the given room on the given date.
	*/
	public void addBooking(String guest, Integer room, Date date);
	
	/**
	* Return a collection of all the available room numbers for the given date
	*/
	public List<Integer> getAvailableRooms(Date date);
}