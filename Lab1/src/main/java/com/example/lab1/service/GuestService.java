package com.example.lab1.service;

import com.example.lab1.model.Guest;
import java.util.List;

public interface GuestService {
    List<Guest> getAllGuests();
    Guest getGuestById(Long id);
    Guest addGuest(Guest guest);
    Guest updateGuest(Long id, Guest guest);
    void deleteGuest(Long id);
}
