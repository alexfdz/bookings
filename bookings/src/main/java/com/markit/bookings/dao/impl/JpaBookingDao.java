package com.markit.bookings.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.markit.bookings.dao.BookingDao;
import com.markit.bookings.model.Booking;
import com.markit.bookings.model.BookingPK;

public class JpaBookingDao implements BookingDao{

	EntityManager entityManager;

	public Booking getById(BookingPK bookingPK) {
		return entityManager.find(Booking.class, bookingPK);
	}

	@SuppressWarnings("unchecked")
	public List<Booking> getAll() {
		Query query = entityManager.createQuery("from " + Booking.class.getName()+ " c");
		return (List<Booking>)query.getResultList();
	}
	
	public void save(Booking booking) {
		entityManager.persist(booking);
		entityManager.flush();
	}

	public void delete(Booking booking) {
		entityManager.remove(booking);
		entityManager.flush();
	}

	public void update(Booking booking) {
		entityManager.persist(booking);
		entityManager.flush();
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
