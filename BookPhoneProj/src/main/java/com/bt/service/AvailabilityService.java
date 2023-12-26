package com.bt.service;

import com.bt.entity.BookingInfo;

public interface AvailabilityService {

	BookingInfo getAvailabilityById(int phoneId);

}
