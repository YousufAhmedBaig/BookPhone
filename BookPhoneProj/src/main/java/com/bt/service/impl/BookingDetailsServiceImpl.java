package com.bt.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.entity.Booking;
import com.bt.repository.BookingDetailsRepository;
import com.bt.service.BookingDetailsService;

@Service
public class BookingDetailsServiceImpl implements BookingDetailsService {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository; 
	
	@Override
	public ArrayList<Booking> getBookingDetailsById(int phoneId) {
		
		ArrayList<Booking> bookingStatusList;		
		bookingStatusList = bookingDetailsRepository.findByPhoneId(phoneId);

		return bookingStatusList;
	}

	@Override
	public Booking bookPhone(Booking newBooking) {
		
		return bookingDetailsRepository.save(newBooking);
		
	}

}