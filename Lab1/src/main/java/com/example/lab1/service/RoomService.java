package com.example.lab1.service;

import com.example.lab1.model.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(Long id);
    Room addRoom(Room room);
    Room updateRoom(Long id, Room room);
    void deleteRoom(Long id);
}
