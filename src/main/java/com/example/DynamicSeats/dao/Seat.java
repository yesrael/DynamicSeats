package com.example.DynamicSeats.dao;

import lombok.Data;

@Data
public class Seat {
    private int seatNumber;
    private boolean isOccupied;
    private Employee employee;
    private Department department;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isOccupied = false;
        this.employee = null;
        this.department = null;
    }

    public void setOccupied(boolean isOccupied, Employee employee, Department department) {
        this.isOccupied = isOccupied;
        this.employee = employee;
        this.department = department;
    }
}
