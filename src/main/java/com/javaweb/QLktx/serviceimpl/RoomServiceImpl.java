package com.javaweb.QLktx.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.repository.RoomRepository;
import com.javaweb.QLktx.services.RoomService;

import jakarta.transaction.Transactional;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomRepository roomRepository;
	
	@Transactional
	public Room save(Room room) {
		Room createResponse = roomRepository.save(room);
		return createResponse;
	}

	@Transactional
	public Room update(Room room) {
		Room updateResponse = roomRepository.save(room);
		return updateResponse;
	}

	@Transactional
	public Room get(Long id) {
		Optional<Room> response = roomRepository.findById(id);
		Room getResponse = response.get();
		return getResponse;
	}

	@Transactional
	public void delete(Long id) {
		roomRepository.deleteById(id);
	}
	
	@Transactional
	public List<Room> getAll() {
	    return roomRepository.findAll();
	}
}
