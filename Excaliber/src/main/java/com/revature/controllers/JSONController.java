package com.revature.controllers;

import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.revature.utils.ParseJSON.readDataFromFile;
import static com.revature.utils.ParseJSON.setTrainer;

@RestController
@RequestMapping(path = "/JSONController")
public class JSONController {

	private final StoreRetrieveService SRSserv;

	@Autowired
	public JSONController(StoreRetrieveService s) {
		SRSserv = s;
		String fileName = "data.json";
		readDataFromFile(fileName);
	}

	@GetMapping
	public ResponseEntity storeTrainer() {
		Trainer trainer = setTrainer();
		System.out.println(trainer);
		SRSserv.addTrainer(
				trainer);
		return ResponseEntity.ok(trainer);

	}
}
