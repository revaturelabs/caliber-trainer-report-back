package com.revature.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Disabled
class TechnicalStatusByWeekControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;


	@BeforeEach
	public void initEach() {
		// TODO: this needs something other than null passed in,
		// whether a mock service or what, because it is a dependency
	    //JSONController jc = new JSONController(null);
	  	//jc.getTrainer2();
	}


	@BeforeAll
	public static void init(){
		// TODO: this needs something other than null passed in,
		// whether a mock service or what, because it is a dependency
	    //JSONController jc = new JSONController(null);
	  	//jc.getTrainer2();
	}


	@Test
    public void technicalStatusByWeek_ShouldReturnBatchData() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port
				+ "/excaliber/TechnicalStatusByWeek", String.class)).contains("batchName");
    }


}
