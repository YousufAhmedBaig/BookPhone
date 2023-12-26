package com.bt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.entity.BookingInfo;
import com.bt.repository.PhonesMasterRepository;
import com.bt.repository.PhonesRepository;
import com.bt.service.AvailabilityService;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {
	
	@Autowired
	private PhonesRepository phonesRepository; 
	
	@Autowired
	private PhonesMasterRepository pmRepository;

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

}
