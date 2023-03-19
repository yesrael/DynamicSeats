package com.example.DynamicSeats.service;

import com.example.DynamicSeats.dao.Department;
import com.example.DynamicSeats.dao.Employee;
import com.example.DynamicSeats.dao.Seat;
import com.example.DynamicSeats.repository.EmployeeRepository;
import com.example.DynamicSeats.repository.SeatsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BussinessService {

    @Autowired
    private final EmployeeRepository employeeRepository;
    @Autowired
    private final SeatsRepository seatsRepository;

    public String getEmployeeName(String phoneNumber){
        return employeeRepository.findByPhoneNumber(phoneNumber).getName();


    }
    public String getEmployeeDepartment(String phoneNumber){
        return employeeRepository.findByPhoneNumber(phoneNumber).getDepartment().getName();


    }

    public String getTop3Seats(int floorNumber, String area){
        return seatsRepository.findByFloorAndArea(floorNumber,area).getSeatNumber();


    }

}
