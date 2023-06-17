package com.javaweb.QLktx.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.QLktx.models.Room;
import com.javaweb.QLktx.services.RoomService;

@RestController
@RequestMapping("/tim-kiem/phong")
public class SearchController {
	@Autowired
    private RoomService roomService;

    @GetMapping("")
    public List<Room> searchRoom(@RequestParam("q") String query) {
    	List<Room> rooms = roomService.getSearchAll(query);
		return rooms;
    }
}
