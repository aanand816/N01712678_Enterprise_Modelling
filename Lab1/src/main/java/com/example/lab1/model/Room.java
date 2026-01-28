package com.example.lab1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float roomSize;
    private Integer noOfBeds;
    private String condition;
    private Integer rent;

    public Room() {
    }

    public Room(Float roomSize, Integer noOfBeds, String condition, Integer rent) {
        this.roomSize = roomSize;
        this.noOfBeds = noOfBeds;
        this.condition = condition;
        this.rent = rent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
