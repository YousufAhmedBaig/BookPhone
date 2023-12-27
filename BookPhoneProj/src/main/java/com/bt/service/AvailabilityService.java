package com.bt.service;

import java.util.ArrayList;

import com.bt.entity.BookingInfo;

public interface AvailabilityService {

	BookingInfo getAvailabilityById(int phoneId);

	ArrayList<BookingInfo> getAvailability();

}
