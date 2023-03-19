package com.example.DynamicSeats.repository;

import com.example.DynamicSeats.dao.Employee;
import com.example.DynamicSeats.dao.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

       import com.example.DynamicSeats.dao.Employee;
               import org.springframework.data.jpa.repository.JpaRepository;
               import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seat,Long> {
      Seat  findByFloorAndArea(int floor, String area);

}