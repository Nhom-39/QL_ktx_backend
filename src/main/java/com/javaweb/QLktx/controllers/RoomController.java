package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.services.RoomService;

@RestController
@RequestMapping("admin/quan-ly-phong")
public class RoomController {
	@Autowired
	private RoomService roomService;
	
	@GetMapping("")
	public List<Room> getAllRoom() {
		List<Room> rooms = roomService.getAll();
        return rooms;
	}

	@PostMapping("/create")
	public Room createroom1(@RequestBody Room room) {
		Room createResponse = roomService.save(room);
		return createResponse;
	}
	
	@PutMapping("/{id}")
	public Room updateroom(@RequestBody Room room) {
		Room updateResponse = roomService.update(room);
		return updateResponse;
	}

	@GetMapping("/{id}/edit")
	public Room getroom(@PathVariable Long id) {
		Room getReponse = roomService.get(id);
		return getReponse;
	}

	@DeleteMapping("/{id}")
	public String deleteroom(@PathVariable Long id) {
		roomService.delete(id);
		return "Record deleted succesfully";
	}
}
