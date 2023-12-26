package com.bt.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bt.entity.Tester;
import com.bt.repository.TestersRepository;
import com.bt.service.TestersService;

@Service
public class TestersServiceImpl implements TestersService {
	
	@Autowired
	private TestersRepository testersRepository;

	@Override
	public ArrayList<Tester> getAllTesters() {
		
		ArrayList<Tester> testersList = (ArrayList<Tester>) testersRepository.findAll();		
	
		return testersList;
	}

}
