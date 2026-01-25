package com.example.lab1.model;

public class Room {
    private Integer roomId;
    private Float roomSize;
    private Integer noOfBeds;
    private String condition;
    private Integer rent;

    public Room() {
    }

    public Room(Integer roomId, Float roomSize, Integer noOfBeds, String condition, Integer rent) {
        this.roomId = roomId;
        this.roomSize = roomSize;
        this.noOfBeds = noOfBeds;
        this.condition = condition;
        this.rent = rent;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Float getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Float roomSize) {
        this.roomSize = roomSize;
    }

    public Integer getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(Integer noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getRent() {
        return rent;
    }

    public void setRent(Integer rent) {
        this.rent = rent;
    }
}
