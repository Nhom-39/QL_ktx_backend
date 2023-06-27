package com.javaweb.QLktx.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.javaweb.QLktx.models.Room;

@Component
public interface RoomService {
	public Room save(Room room);
	public Room update(Room room);
	public Room get(Long id);
	public void delete(Long id);
	public List<Room> getAll();
	public List<Room> getSearchAll(String query);
}
