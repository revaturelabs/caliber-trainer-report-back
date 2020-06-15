package com.revature.controllers;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.StoreRetrieveService;
import com.revature.utils.ParseJSON;

import static com.revature.utils.ParseJSON.readDataFromFile;

import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class MainController {
	
	private StoreRetrieveService SRSserv;
	@Autowired
	public MainController(StoreRetrieveService s) {
		SRSserv=s;
	}
	
	public void storeTrainer() {
		ParseJSON ps=new ParseJSON();
		String fileName = "data.json";
		ps.readDataFromFile(fileName);
	}
}
