package com.revature.controllers;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.revature.utils.ParseJSON.setBatchData;
import static com.revature.utils.ParseJSON.setTrainer;

@RestController
@RequestMapping(path = "/JSONController")
public class JSONController {

	private final StoreRetrieveService SRSserv;

	@Autowired
	public JSONController(StoreRetrieveService s) {
		SRSserv = s;


		//String fileName = "data.json";
		//readDataFromFile(fileName);

	}

	@GetMapping
	public ResponseEntity<String> storeTrainer() {

//	public ResponseEntity<Trainer> storeTrainer() {

		Trainer trainer = setTrainer();
		Set<Batch> batches = setBatchData();
		trainer.setBatches(batches);
//		return ResponseEntity.ok(SRSserv
//				.getTrainerById(SRSserv.addEntireTrainer(
//						trainer).getId()));
		SRSserv.addEntireTrainer(trainer);
		return ResponseEntity.ok().build();

	}
}
