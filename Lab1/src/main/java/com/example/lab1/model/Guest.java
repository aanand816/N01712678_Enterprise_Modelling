package com.example.lab1.model;

public class Guest {
    private Integer guestId;
    private String guestName;
    private String contact;
    private String email;
    private String address;

    public Guest() {
    }

    public Guest(Integer guestId, String guestName, String contact, String email, String address) {
        this.guestId = guestId;
        this.guestName = guestName;
        this.contact = contact;
        this.email = email;
        this.address = address;
    }

    public Integer getGuestId() {
        return guestId;
    }

    public void setGuestId(Integer guestId) {
        this.guestId = guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
