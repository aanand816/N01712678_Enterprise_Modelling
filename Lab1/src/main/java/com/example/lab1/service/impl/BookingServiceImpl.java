package com.example.lab1.service.impl;

import com.example.lab1.model.Booking;
import com.example.lab1.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingServiceImpl implements BookingService {

    private final Map<Integer, Booking> bookings = new HashMap<>();
    private Integer nextId = 1;

    @Override
    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }

    @Override
    public Booking getBookingById(Integer id) {
        return bookings.get(id);
    }

    @Override
    public Booking addBooking(Booking booking) {
        booking.setBookingId(nextId++);
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Booking updateBooking(Integer id, Booking booking) {
        if (!bookings.containsKey(id)) {
            return null;
        }
        booking.setBookingId(id);
        bookings.put(id, booking);
        return booking;
    }

    @Override
    public void deleteBooking(Integer id) {
        bookings.remove(id);
    }

    @Override
    public List<Booking> getBookingsByGuestId(Integer guestId) {
        List<Booking> result = new ArrayList<>();
        for (Booking booking : bookings.values()) {
            if (booking.getGuestId() != null && booking.getGuestId().equals(guestId)) {
                result.add(booking);
            }
        }
        return result;
    }
}
