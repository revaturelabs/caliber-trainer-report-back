package com.revature.controllers;

import com.revature.beans.Batch;
import com.revature.beans.Trainer;
import com.revature.services.StoreRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.revature.utils.ParseJSON.*;

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
	}

	/**
	 * TODO
	 *
	 * @return string response entity
	 */
	@GetMapping
	public ResponseEntity<String> getTrainer2() {

//	public ResponseEntity<Trainer> storeTrainer() {


		Trainer trainer = getTrainer();
		List<Batch> batches = getBatch();

		trainer.setBatches(batches);
//		return ResponseEntity.ok(SRSserv
//				.getTrainerById(SRSserv.addEntireTrainer(
//						trainer).getId()));
		SRSserv.addEntireTrainer(trainer);
		return ResponseEntity.ok().build();

	}

	/**
	 * @param payload JSON body to be stored in db
	 * @return
	 */
	@PostMapping(consumes = "application/json", produces = "application/json")
	public Boolean addTrainer(@RequestBody String payload) {
		//set the JSON to be parsed
		setJson(payload);
		//create a trainer from the JSON payload
		Trainer trainer = getTrainer();
		//get the batch data
		List<Batch> batches = getBatch();
		//give trainer the batches
		trainer.setBatches(batches);
		//if trainer created
		return SRSserv.addEntireTrainer(trainer).getTrainerId() != -1;
	}
}
