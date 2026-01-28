package com.example.lab1.service;

import com.example.lab1.model.Booking;
import java.util.List;

public interface BookingService {
    List<Booking> getAllBookings();
    Booking getBookingById(Long id);
    Booking addBooking(Booking booking);
    Booking updateBooking(Long id, Booking booking);
    void deleteBooking(Long id);
    List<Booking> getBookingsByGuestId(Long guestId);
}
