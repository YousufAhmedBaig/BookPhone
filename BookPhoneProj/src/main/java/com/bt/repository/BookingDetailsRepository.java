package com.bt.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bt.entity.Booking;

public interface BookingDetailsRepository extends JpaRepository<Booking,Integer>{

	ArrayList<Booking> findByPhoneId(int phoneId);

}
