package com.revature.tests;



import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.beans.Batch;
import com.revature.services.StoreRetrieveService;



public class TRMStest {
@Autowired
StoreRetrieveService srs;
	
	@Test
		public void batch() {
		boolean t = false;	
		Batch b = srs.getbyBatchId("Ix2x2UAB");
			List<Batch> bl = srs.getBatchesByTrainer(1);
			if( bl.contains(b)) {
			t=true;
			}
			Assertions.assertTrue(t);
	}
}