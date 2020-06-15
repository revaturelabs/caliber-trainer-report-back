package com.revature.controllers;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

import static com.revature.utils.ParseJSON.getBatch;
import static com.revature.utils.ParseJSON.getTrainer;

/**
 * The type Json controller.
 */
@RestController
@RequestMapping(path = "/JSONController")
public class JSONController {

	private final StoreRetrieveService SRSserv;

	/**
	 * Instantiates a new Json controller.
	 *
	 * @param s the s
	 */
	@Autowired
	public JSONController(StoreRetrieveService s) {
		SRSserv = s;
		//String fileName = "data.json";
		//readDataFromFile(fileName);
	}

	/**
	 * TODO
	 *
	 * @return string
	 */
	@GetMapping
	public String storeTrainer() {

//	public ResponseEntity<Trainer> storeTrainer() {

		Trainer trainer = getTrainer();
		Set<Batch> batches = getBatch();
		trainer.setBatches(batches);
//		return ResponseEntity.ok(SRSserv
//				.getTrainerById(SRSserv.addEntireTrainer(
//						trainer).getId()));
		SRSserv.addEntireTrainer(trainer);
		return "Works";

	}
}
