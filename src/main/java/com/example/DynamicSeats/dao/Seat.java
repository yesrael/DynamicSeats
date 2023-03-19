package com.example.DynamicSeats.dao;


import lombok.Data;

import javax.persistence.*;
import javax.persistence.*;

@Table(name = "seats")
@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String seatNumber;
    private int floor;
    private String area;
    private boolean isOccupied;

    @JoinColumn(name = "employee_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Employee employee;

    @JoinColumn(name = "department_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Department department;

    public Seat(String seatNumber){
        this.seatNumber = seatNumber;
        this.isOccupied = false;
        this.employee = null;
        this.department = null;
    }
    public Seat(){}
    public void setOccupied(boolean isOccupied, Employee employee, Department department){
        this.isOccupied = isOccupied;
        //this.employee = employee;
        // this.department = department;
    }
}
