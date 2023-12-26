package com.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bt.entity.Booking;

public interface PhonesRepository extends JpaRepository<Booking,Integer> {
	
@Query(nativeQuery=true, value="select\r\n"
		+ "(select phone_quantity from phones_master where phone_id=:phoneId) -\r\n"
		+ "((select count(quantity) from booking_details where phone_id=:phoneId and booking_activity='booked') - \r\n"
		+ "(select count(quantity) from booking_details where phone_id=:phoneId and booking_activity='returned')) \r\n"
		+ "as total")	

	int findByPhoneId(int phoneId);
}
