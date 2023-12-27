package com.bt.service.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.entity.Booking;
import com.bt.entity.BookingInfo;
import com.bt.repository.BookingDetailsRepository;
import com.bt.repository.PhonesMasterRepository;
import com.bt.repository.PhonesRepository;
import com.bt.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	private PhonesRepository phonesRepository; 
	
	@Autowired
	private PhonesMasterRepository pmRepository;
	
	@Autowired
	BookingDetailsRepository bookingDetailsRepository;

	@Override
	public BookingInfo getAvailabilityById(int phoneId) {
		
		BookingInfo bookingInfo = new BookingInfo();
		bookingInfo.setPhoneId(phoneId);
		int total = 0;
		String name = "";
		
		name = pmRepository.findNameByPhoneId(phoneId);
		bookingInfo.setPhoneName(name);
		
		total = phonesRepository.findByPhoneId(phoneId);
		
		if (total > 0) {
			bookingInfo.setAvailability("Available");			
		} else {
			bookingInfo.setAvailability("Unavailable");
		}
		
		return bookingInfo;		
	}

	// Returns booking availability of all the phones in the db. Work in progress - FIXME. 
	@Override
	public ArrayList<BookingInfo> getAvailability() {
		
		ArrayList<Booking> allBookingsList = (ArrayList<Booking>) pmRepository.findAll();		
		Iterator iterator = allBookingsList.iterator();
		Booking booking;
		BookingInfo bookingInfo;
		int phoneId;
		ArrayList<BookingInfo> infoList = new ArrayList<BookingInfo>();
		
		while(iterator.hasNext()) {
			booking = (Booking) iterator.next();
			phoneId = booking.getPhoneId();
			bookingInfo = getAvailabilityById(phoneId);
			infoList.add(bookingInfo);
		}
		
		return infoList;
	}

}
