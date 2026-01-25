package com.example.lab1.service.impl;

import com.example.lab1.model.Guest;
import com.example.lab1.service.GuestService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestServiceImpl implements GuestService {

    private final Map<Integer, Guest> guests = new HashMap<>();
    private Integer nextId = 1;

    @Override
    public List<Guest> getAllGuests() {
        return new ArrayList<>(guests.values());
    }

    @Override
    public Guest getGuestById(Integer id) {
        return guests.get(id);
    }

    @Override
    public Guest addGuest(Guest guest) {
        guest.setGuestId(nextId++);
        guests.put(guest.getGuestId(), guest);
        return guest;
    }

    @Override
    public Guest updateGuest(Integer id, Guest guest) {
        if (!guests.containsKey(id)) {
            return null;
        }
        guest.setGuestId(id);
        guests.put(id, guest);
        return guest;
    }

    @Override
    public void deleteGuest(Integer id) {
        guests.remove(id);
    }
}
