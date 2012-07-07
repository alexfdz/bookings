package com.markit.bookings.dao;

import java.util.List;

import com.markit.bookings.model.Booking;
import com.markit.bookings.model.BookingPK;

public interface BookingDao {

	Booking getById(BookingPK bookingPK);
    
    void save(Booking booking);

    void delete(Booking booking);

    void update(Booking booking);
    
    List<Booking> getAll();

}
