package com.bt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bt.entity.Tester;

public interface TestersRepository extends JpaRepository<Tester,Integer> {
	

}
