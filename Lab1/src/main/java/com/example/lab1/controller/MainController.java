package com.example.lab1.controller;

import com.example.lab1.model.Room;
import com.example.lab1.model.Guest;
import com.example.lab1.model.Booking;
import com.example.lab1.service.RoomService;
import com.example.lab1.service.GuestService;
import com.example.lab1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private GuestService guestService;

    @Autowired
    private BookingService bookingService;

    // ---------- Room endpoints ----------

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @PutMapping("/rooms/{id}")
    public Room updateRoom(@PathVariable Integer id, @RequestBody Room room) {
        return roomService.updateRoom(id, room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }

    // ---------- Guest endpoints ----------

    @GetMapping("/guests")
    public List<Guest> getAllGuests() {
        return guestService.getAllGuests();
    }

    @GetMapping("/guests/{id}")
    public Guest getGuestById(@PathVariable Integer id) {
        return guestService.getGuestById(id);
    }

    @PostMapping("/guests")
    public Guest addGuest(@RequestBody Guest guest) {
        return guestService.addGuest(guest);
    }

    @PutMapping("/guests/{id}")
    public Guest updateGuest(@PathVariable Integer id, @RequestBody Guest guest) {
        return guestService.updateGuest(id, guest);
    }

    @DeleteMapping("/guests/{id}")
    public void deleteGuest(@PathVariable Integer id) {
        guestService.deleteGuest(id);
    }

    // ---------- Booking endpoints ----------

    @GetMapping("/bookings")
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/bookings/{id}")
    public Booking getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id);
    }

    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking) {
        return bookingService.addBooking(booking);
    }

    @PutMapping("/bookings/{id}")
    public Booking updateBooking(@PathVariable Integer id, @RequestBody Booking booking) {
        return bookingService.updateBooking(id, booking);
    }

    @DeleteMapping("/bookings/{id}")
    public void deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
    }

    // Extra: all bookings for a guest
    @GetMapping("/guests/{guestId}/bookings")
    public List<Booking> getBookingsForGuest(@PathVariable Integer guestId) {
        return bookingService.getBookingsByGuestId(guestId);
    }
}
