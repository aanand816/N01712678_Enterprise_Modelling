package com.example.lab1.service;

import com.example.lab1.model.Booking;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Integer id);
    Booking addBooking(Booking booking);
    Booking updateBooking(Integer id, Booking booking);
    void deleteBooking(Integer id);

    // extra: all bookings for a given guest
    List<Booking> getBookingsByGuestId(Integer guestId);
}
