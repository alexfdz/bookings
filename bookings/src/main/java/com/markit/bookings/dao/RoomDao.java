package com.markit.bookings.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.markit.bookings.model.Room;

public interface RoomDao {

	Room getById(int id);
    
    void save(Room room);

    void delete(Room room);

    void update(Room room);

    List<Room> getAll();
    
}
