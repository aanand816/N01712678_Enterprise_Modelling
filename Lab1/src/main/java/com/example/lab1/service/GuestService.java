package com.example.lab1.service;

import com.example.lab1.model.Guest;
import java.util.List;

public interface GuestService {
    List<Guest> getAllGuests();
    Guest getGuestById(Integer id);
    Guest addGuest(Guest guest);
    Guest updateGuest(Integer id, Guest guest);
    void deleteGuest(Integer id);
}
