package com.markit.bookings.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.markit.bookings.dao.RoomDao;
import com.markit.bookings.model.Room;

public class JpaRoomDao implements RoomDao {

	EntityManager entityManager;

	public Room getById(int id) {
		return entityManager.find(Room.class, id);
	}

	public void save(Room room) {
		entityManager.persist(room);
		entityManager.flush();
	}

	public void delete(Room room) {
		entityManager.remove(room);
		entityManager.flush();
	}

	public void update(Room room) {
		entityManager.persist(room);
		entityManager.flush();
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@SuppressWarnings("unchecked")
	public List<Room> getAll() {
		Query query = entityManager.createQuery("from " + Room.class.getName()+ " c");
		return (List<Room>)query.getResultList();
	}
}
