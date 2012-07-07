package com.markit.bookings.bo.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;

import com.markit.bookings.bo.BookingManager;
import com.markit.bookings.dao.BookingDao;
import com.markit.bookings.dao.RoomDao;
import com.markit.bookings.model.Booking;
import com.markit.bookings.model.BookingPK;
import com.markit.bookings.model.Room;


public class JpaBookingManager implements BookingManager{

	private BookingDao bookingDao;
	private RoomDao roomDao;
	

	/* (non-Javadoc)
	 * @see com.markit.bookings.bo.BookingManager#isRoomAvailable(java.lang.Integer, java.util.Date)
	 */
	public boolean isRoomAvailable(Integer room, Date date) {
		BookingPK bookingPK = new BookingPK(new Room(room), date);
		if(bookingDao.getById(bookingPK) != null){
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.markit.bookings.bo.BookingManager#addBooking(java.lang.String, java.lang.Integer, java.util.Date)
	 */
	public void addBooking(String guest, Integer room, Date date) {
		if(!StringUtils.hasText(guest) || room == null || date == null){
			throw new IllegalArgumentException();
		}
		BookingPK bookingPK = new BookingPK(new Room(room), date);
		Booking booking = new Booking(bookingPK, guest);
		bookingDao.save(booking);
	}

	/* (non-Javadoc)
	 * @see com.markit.bookings.bo.BookingManager#getAvailableRooms(java.util.Date)
	 */
	public List<Integer> getAvailableRooms(Date date) {
		List<Room> allRooms = roomDao.getAll();
		List<Integer> availableRooms = new ArrayList<Integer>();
		for (Room room : allRooms) {
			if(isRoomAvailable(room.getId(), date)){
				availableRooms.add(room.getId());
			}
		}
		return availableRooms;
	}

	public BookingDao getBookingDao() {
		return bookingDao;
	}

	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}

	public RoomDao getRoomDao() {
		return roomDao;
	}

	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

}
