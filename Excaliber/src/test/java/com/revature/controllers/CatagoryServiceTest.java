package com.revature.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.revature.Excaliber;

@SpringBootTest(classes=Excaliber.class)

@AutoConfigureMockMvc

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class CatagoryServiceTest {
	

    MockMvc mvc;


    @Autowired
	@MockBean
	RestTemplate restTemplate;
    
    @BeforeEach
    public void setUp(WebApplicationContext webApplicationContext,
                      RestDocumentationContextProvider restDocumentation) throws Exception {
        this.mvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(documentationConfiguration(restDocumentation))
                .build();
        this.mvc.perform(RestDocumentationRequestBuilders.get("/CategoryService"));
    }
    

	@Test
	public void testgetQcNoteByBatchId() throws Exception {
		String id ="296";
		///Batch b= cont.getBatchById(id);

		HttpEntity<String> myEntity = new HttpEntity<>("Nice");
		String response = "Response";
		ResponseEntity<String> mockResponse = new ResponseEntity<>("Responses",HttpStatus.OK);
        
        Mockito.when(restTemplate.exchange(any(String.class), any(HttpMethod.class), any(HttpEntity.class), any(Class.class))).thenReturn(mockResponse);
		
		this.mvc.perform(RestDocumentationRequestBuilders.get("/Category/category/{id}","296"))
        .andExpect(status().isOk())
        .andDo(document("Category/category/296"));
	}

}
