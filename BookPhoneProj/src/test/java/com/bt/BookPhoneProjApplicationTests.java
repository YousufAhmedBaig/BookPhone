package com.bt;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bt.entity.Booking;
import com.bt.repository.BookingDetailsRepository;
import com.bt.repository.PhonesRepository;

@SpringBootTest
class BookPhoneProjApplicationTests {
	
@Autowired
private BookingDetailsRepository bookingDetailsRepository;

@Autowired
PhonesRepository phonesRepository;

@Test
public void testNewBooking() {	
	
	Booking booking = new Booking();
	Booking savedBooking;
	booking.setBookingActivity("booked");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	booking.setBookingDate(timestamp);
	booking.setPhoneId(2);
	booking.setQuantity(1);
	booking.setTesterId(1);
	
	savedBooking = bookingDetailsRepository.save(booking);
	
	if (savedBooking.getBookingDate() == timestamp) {		
		System.out.println(savedBooking.toString());      // To quickly validate on the console.
		assert(true);
	}else {
		assert(false);
	}
}


@Test
public void testPhoneReturned() {	
	
	Booking booking = new Booking();
	Booking savedBooking;
	booking.setBookingActivity("returned");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	booking.setBookingDate(timestamp);
	booking.setPhoneId(2);
	booking.setQuantity(1);
	booking.setTesterId(1);
	
	savedBooking = bookingDetailsRepository.save(booking);
	
	if (savedBooking.getBookingDate() == timestamp) {		
		System.out.println(savedBooking.toString());      // To quickly validate on the console.
		assert(true);
	}else {
		assert(false);
	}
}

@Test
public void testBookingNReturnStatus() {
	
	ArrayList<Booking> bookingList = bookingDetailsRepository.findByPhoneId(2);
	Booking booking;
	String booked;
	Iterator<Booking> iterator = bookingList.iterator();
	
	while(iterator.hasNext()) {
		booking = (Booking)iterator.next();
		booked = booking.getBookingActivity();
		
		if (booked.equalsIgnoreCase("booked") || booked.equalsIgnoreCase("returned")) {
			System.out.println("Booking status for phone id 2: "+booked+ " with Booking id: " + booking.getBookingId() );      // To quickly validate on the console.
			assert(true);		
		} else {
			assert(false);
		}
	}	
}

@Test()
public void testPhoneAvailability() {	
	int count;
	try {
		count =	phonesRepository.findByPhoneId(2);
		System.out.println("Total available phones with id 2 is: " + count);
		assert(true);
	}catch(Exception excep) {
		assert(false);
	}	

}

}
