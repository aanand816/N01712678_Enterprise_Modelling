package com.example.lab1.service;

import com.example.lab1.model.Room;
import java.util.List;

public interface RoomService {
    List<Room> getAllRooms();
    Room getRoomById(Integer id);
    Room addRoom(Room room);
    Room updateRoom(Integer id, Room room);
    void deleteRoom(Integer id);
}
