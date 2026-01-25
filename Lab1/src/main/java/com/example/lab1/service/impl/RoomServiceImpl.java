package com.example.lab1.service.impl;

import com.example.lab1.model.Room;
import com.example.lab1.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RoomServiceImpl implements RoomService {

    private final Map<Integer, Room> rooms = new HashMap<>();
    private Integer nextId = 1;

    @Override
    public List<Room> getAllRooms() {
        return new ArrayList<>(rooms.values());
    }

    @Override
    public Room getRoomById(Integer id) {
        return rooms.get(id);
    }

    @Override
    public Room addRoom(Room room) {
        room.setRoomId(nextId++);
        rooms.put(room.getRoomId(), room);
        return room;
    }

    @Override
    public Room updateRoom(Integer id, Room room) {
        if (!rooms.containsKey(id)) {
            return null;
        }
        room.setRoomId(id);
        rooms.put(id, room);
        return room;
    }

    @Override
    public void deleteRoom(Integer id) {
        rooms.remove(id);
    }
}
