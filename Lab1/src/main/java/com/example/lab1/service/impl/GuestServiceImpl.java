package com.example.lab1.service.impl;

import com.example.lab1.model.Guest;
import com.example.lab1.repository.GuestRepository;
import com.example.lab1.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Guest getGuestById(Long id) {
        return guestRepository.findById(id).orElse(null);
    }

    @Override
    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    public Guest updateGuest(Long id, Guest guest) {
        if (!guestRepository.existsById(id)) {
            return null;
        }
        guest.setId(id);
        return guestRepository.save(guest);
    }

    @Override
    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
