package com.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bt.entity.Booking;

public interface PhonesMasterRepository extends JpaRepository<Booking,Integer> {

	@Query(nativeQuery=true, value="select phone_name from phones_master where phone_id=:phoneId")	

		String findNameByPhoneId(int phoneId);	

}
