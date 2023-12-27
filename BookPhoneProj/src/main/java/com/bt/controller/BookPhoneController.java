package com.bt.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.entity.BookingInfo;
import com.bt.entity.Booking;
import com.bt.entity.Tester;
import com.bt.service.AvailabilityService;
import com.bt.service.BookingDetailsService;
import com.bt.service.BookingService;
import com.bt.service.TestersService;
import com.bt.service.AvailabilityService;

@RestController
@RequestMapping("/phones")
public class BookPhoneController {
	
	@Autowired
	private AvailabilityService availabilityService;
	@Autowired
	private BookingDetailsService bookingDetailsService;
	@Autowired
	private TestersService testersService;
	
	
	// Get phone availability by id REST API
    // http://localhost:8080/phones/availability/7
	
	@GetMapping("availability/{phoneId}")
    public ResponseEntity<BookingInfo> getAvailabilityByPhoneId(@PathVariable("phoneId") int phoneId){
		
        BookingInfo bookingInfo = availabilityService.getAvailabilityById(phoneId);
        return new ResponseEntity<>(bookingInfo, HttpStatus.OK);
    }
	
	// Get phone availability by id REST API
    // http://localhost:8080/phones/availability
	
	@GetMapping("availability")
    public ResponseEntity<ArrayList<BookingInfo>> getAvailabilityForAllPhones() {
		
        ArrayList<BookingInfo> bookingInfoList = availabilityService.getAvailability();
        return new ResponseEntity<>(bookingInfoList, HttpStatus.OK);
    }
	
	// Get phone booking details by id REST API
    // http://localhost:8080/phones/bookings/7
	
	@GetMapping("bookings/{phoneId}")
    public ResponseEntity<ArrayList<Booking>> getBookingDetailsByPhoneId(@PathVariable("phoneId") int phoneId){
		
        ArrayList<Booking> bookingStatusList = bookingDetailsService.getBookingDetailsById(phoneId);
        return new ResponseEntity<>(bookingStatusList, HttpStatus.OK);
    }
	
	// Get list of all the testers for quick reference.
    // http://localhost:8080/phones/testers
	
	@GetMapping("testers")
    public ResponseEntity<ArrayList<Tester>> getTesters(){
		
        ArrayList<Tester> testersList = testersService.getAllTesters();
        return new ResponseEntity<>(testersList, HttpStatus.OK);
    }
	
	
	// Booking and returning activities.
    // http://localhost:8080/phones/booking
	
	@PostMapping("booking")
    public ResponseEntity<Booking> newBooking(@RequestBody Booking newBooking) {
		
        Booking booking = bookingDetailsService.bookPhone(newBooking);        
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }
	
	
	
	

}
