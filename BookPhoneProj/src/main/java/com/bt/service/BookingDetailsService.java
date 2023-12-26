package com.bt.service;

import java.util.ArrayList;

import com.bt.entity.Booking;

public interface BookingDetailsService {

	ArrayList<Booking> getBookingDetailsById(int phoneId);

	Booking bookPhone(Booking newBooking);

}
