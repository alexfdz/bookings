package com.markit.bookings.bo;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.markit.bookings.dao.BookingDao;
import com.markit.bookings.dao.RoomDao;
import com.markit.bookings.model.Booking;
import com.markit.bookings.model.Room;

@ContextConfiguration(locations={"/test-context.xml"})
public class BookingManagerTest extends AbstractTransactionalJUnit4SpringContextTests {
	
	private BookingManager bookingManager;
	private RoomDao roomDao;
	private BookingDao bookingDao;

	@Before
	public void initData(){
		roomDao.save(new Room(101));
		roomDao.save(new Room(102));
		roomDao.save(new Room(201));
		roomDao.save(new Room(203));
		
		List<Room> rooms = roomDao.getAll();
		Assert.assertNotNull(rooms);
		Assert.assertEquals(4, rooms.size());
		logger.info("Added four rooms");
		
		Date now = java.sql.Date.valueOf("2012-03-28");
		bookingManager.addBooking("Smith", 101, now);
		bookingManager.addBooking("Carter", 102, now);
		logger.info("Created two new bookings");
	}
	
	@Test
	public void testContext(){
		Assert.assertNotNull(bookingManager);
		Assert.assertNotNull(roomDao);
	}
	
	@Test
	public void testAddBookings(){
		Date now = java.sql.Date.valueOf("2012-03-28");
		bookingManager.addBooking("Parsons", 201, now);

		List<Booking> bookings = bookingDao.getAll();
		Assert.assertNotNull(bookings);
		Assert.assertEquals(3, bookings.size());
		logger.info("Created a new booking");
	}
	
	@Test
	public void testIsRoomAvailable(){
		Date now = java.sql.Date.valueOf("2012-03-28");
		bookingManager.addBooking("Parsons", 201, now);

		Assert.assertFalse(bookingManager.isRoomAvailable(201, now));
		logger.info("Room 101 is not available today");
		Assert.assertTrue(bookingManager.isRoomAvailable(202, now));
		logger.info("Room 201 is available today");
	}
	
	@Test
	public void testGetAvailableRooms(){
		Date now = java.sql.Date.valueOf("2012-03-28");
		List<Integer>  availableRooms = bookingManager.getAvailableRooms(now);
		Assert.assertNotNull(availableRooms);
		Assert.assertEquals(2, availableRooms.size());
	}
	
	@Resource
	public void setBookingManager(BookingManager bookingManager) {
		this.bookingManager = bookingManager;
	}
	
	@Resource
	public void setRoomDao(RoomDao roomDao) {
		this.roomDao = roomDao;
	}
	@Resource
	public void setBookingDao(BookingDao bookingDao) {
		this.bookingDao = bookingDao;
	}
	
}
