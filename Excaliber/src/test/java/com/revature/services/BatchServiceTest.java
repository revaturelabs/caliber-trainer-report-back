package com.revature.services;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.Excaliber;
import com.revature.beans.Batch;
import com.revature.beans.CompleteBatch;
import com.revature.controllers.CompleteBatchDataController;
import com.revature.data.TrainerDAO;

@SpringBootTest
@ContextConfiguration(classes = Excaliber.class)
@RunWith(MockitoJUnitRunner.class)
public class BatchServiceTest {
	
	@InjectMocks
	BatchService batchServ;
	
	ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	@Mock
	RestTemplate restTemplate;
	
	@Mock
	TrainerDAO td;
	
	@Test
	public void testgetCompleteBatchDataByIdContainsQC()
	{
		batchServ = new BatchService(restTemplate,td);
		HttpHeaders headers = new HttpHeaders();
    	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		//restTemplate = mock(RestTemplate.class);
		//cont.restTemplate = restTemplate;
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/assessments?batchId=" + "1" , HttpMethod.GET,entity, String.class))
		.thenReturn(ResponseEntity.ok("[{\"assessmentId\":3737,\"rawScore\":100,\"assessmentTitle\":\"Mock Assessment 1-0\",\"assessmentType\":\"Presentation\",\"weekNumber\":1,\"batchId\":\"TR-1014\",\"assessmentCategory\":25,\"assignmentDate\":null}]"));
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/notes/batch/"+"1", HttpMethod.GET, entity, String.class))
		.thenReturn(ResponseEntity.ok("[{\"noteId\":29917,\"content\":\"This is a Qc batch note on week 1\",\"week\":1,\"batchId\":\"TR-1014\",\"associateId\":null,\"employeeId\":\"QC-User\",\"type\":\"QC_BATCH\",\"technicalStatus\":\"Good\",\"createdOn\":null,\"lastUpdated\":null}]"));
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/training/batch/"+"1", HttpMethod.GET, entity, String.class))
		.thenReturn(ResponseEntity.ok("{\"id\":12,\"batchId\":\"TR-1014\",\"name\":\"Mock Batch 12\",\"startDate\":\"2016-01-22\",\"endDate\":\"2016-04-01\",\"skill\":\"SalesForce\",\"location\":\"Tampa\",\"type\":\"Corporate\",\"goodGrade\":70,\"passingGrade\":80,\"employeeAssignments\":[{\"role\":\"ROLE_LEAD_TRAINER\",\"employee\":{\"email\":\"mock1018.employee024e08ae-e448-4f31-aba5-42a3b11e0046@mock.com\",\"firstName\":\"Mock 1018\",\"lastName\":\"Employee 1018\"},\"deletedAt\":null}],\"associateAssignments\":[{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock10.associate4fff708c-c86b-461d-8751-d57fe1d91e50@mock.com\",\"salesforceId\":\"SF-1218\",\"firstName\":\"Mock 10\",\"lastName\":\"Associate 10\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock0.associatef7f9be4e-75a2-4f57-af67-8234f08b55f6@mock.com\",\"salesforceId\":\"SF-1208\",\"firstName\":\"Mock 0\",\"lastName\":\"Associate 0\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock13.associate247b589e-fa5c-482f-ac67-022b8900a8fc@mock.com\",\"salesforceId\":\"SF-1221\",\"firstName\":\"Mock 13\",\"lastName\":\"Associate 13\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock15.associate1971c38b-51ce-46b0-8776-223d8f3b2ffc@mock.com\",\"salesforceId\":\"SF-1223\",\"firstName\":\"Mock 15\",\"lastName\":\"Associate 15\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock5.associatef1571bda-f05f-47bc-b027-b979900e6b91@mock.com\",\"salesforceId\":\"SF-1213\",\"firstName\":\"Mock 5\",\"lastName\":\"Associate 5\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock9.associatee4a088b3-e9b5-402c-8ee7-16ebefb8aadd@mock.com\",\"salesforceId\":\"SF-1217\",\"firstName\":\"Mock 9\",\"lastName\":\"Associate 9\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock14.associate54793cf5-b166-4912-8402-72bf021c3f1a@mock.com\",\"salesforceId\":\"SF-1222\",\"firstName\":\"Mock 14\",\"lastName\":\"Associate 14\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock7.associate35840646-9c5b-43cd-add4-ecb184e9777e@mock.com\",\"salesforceId\":\"SF-1215\",\"firstName\":\"Mock 7\",\"lastName\":\"Associate 7\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock1.associate18645e51-161f-4537-9684-64d3a3712d4d@mock.com\",\"salesforceId\":\"SF-1209\",\"firstName\":\"Mock 1\",\"lastName\":\"Associate 1\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock17.associate96f1bafe-d653-481e-b22a-be4ca00b0765@mock.com\",\"salesforceId\":\"SF-1225\",\"firstName\":\"Mock 17\",\"lastName\":\"Associate 17\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock16.associateead3ab1c-5210-45a4-96ad-73c52f3c072f@mock.com\",\"salesforceId\":\"SF-1224\",\"firstName\":\"Mock 16\",\"lastName\":\"Associate 16\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock11.associatedf832ca3-5164-4d76-b210-16d4a3ebd6c2@mock.com\",\"salesforceId\":\"SF-1219\",\"firstName\":\"Mock 11\",\"lastName\":\"Associate 11\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock19.associatef9e7ed4e-2104-4274-9ab0-7318195c0f88@mock.com\",\"salesforceId\":\"SF-1227\",\"firstName\":\"Mock 19\",\"lastName\":\"Associate 19\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock12.associateab78f8d3-3ab7-4754-8e21-289d0373afe8@mock.com\",\"salesforceId\":\"SF-1220\",\"firstName\":\"Mock 12\",\"lastName\":\"Associate 12\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock3.associatec88b8905-6fa8-4d0f-8674-8c3c2d31068d@mock.com\",\"salesforceId\":\"SF-1211\",\"firstName\":\"Mock 3\",\"lastName\":\"Associate 3\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock4.associate8d36fe50-c0af-41c0-ab67-9dd66c093680@mock.com\",\"salesforceId\":\"SF-1212\",\"firstName\":\"Mock 4\",\"lastName\":\"Associate 4\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock18.associatef2841d37-c3c5-4cee-89e1-0817c6e25488@mock.com\",\"salesforceId\":\"SF-1226\",\"firstName\":\"Mock 18\",\"lastName\":\"Associate 18\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock8.associate41583a6d-2a2d-4b9e-aaf5-1975776afe42@mock.com\",\"salesforceId\":\"SF-1216\",\"firstName\":\"Mock 8\",\"lastName\":\"Associate 8\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock6.associatebb3b7702-95e6-4980-b2d4-a028d50355bf@mock.com\",\"salesforceId\":\"SF-1214\",\"firstName\":\"Mock 6\",\"lastName\":\"Associate 6\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true},{\"trainingStatus\":\"Training\",\"associate\":{\"email\":\"mock2.associatecffad82b-da09-4def-8190-3fb7fa9ffa1e@mock.com\",\"salesforceId\":\"SF-1210\",\"firstName\":\"Mock 2\",\"lastName\":\"Associate 2\",\"flag\":null},\"startDate\":\"2016-04-01\",\"endDate\":\"2016-01-22\",\"active\":true}],\"currentWeek\":11}"));
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/qa/category/1/1", HttpMethod.GET, entity, String.class))
		.thenReturn(ResponseEntity.ok(null));
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/category/category/25", HttpMethod.GET, entity, String.class))
		.thenReturn(ResponseEntity.ok("{\"categoryId\":25,\"skillCategory\":\"jUnit\",\"active\":true}"));
		when(restTemplate.exchange("https://caliber2-mock.revaturelabs.com/mock/evaluation/grades/average?assessment=3737", HttpMethod.GET, entity, String.class))
		.thenReturn(ResponseEntity.ok("47.99127779006958"));
		CompleteBatch resp = new CompleteBatch();
		
		try {
			resp = batchServ.getCompleteBatchDataById("1", mapper);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		assertTrue(resp.getQCNotes().size() > 0);
	}
	
}
