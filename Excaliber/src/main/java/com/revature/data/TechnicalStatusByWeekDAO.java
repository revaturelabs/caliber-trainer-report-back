package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.revature.tables.TechnicalStatusByWeek;

@Repository
public class TechnicalStatusByWeekDAO {
	public Logger log = Logger.getLogger(TechnicalStatusByWeekDAO.class);
	
	public List<TechnicalStatusByWeek> getTableData() {
		log.info("TechnicalStatusByWeekDAO: "
				+ "Getting table data for TechnicalStatusByWeek");
		List<TechnicalStatusByWeek> tableData = null;
		
		//TODO algorithm for getting data from DB 
		//and returning a List of TechnicalStatusByWeek objects
		
		//for each batch
			// for each week of that batch
				// for each category that week
					// add new TechnicalStatusByWeek(batchId, score, category, weekNumber)
		
		// start temp sample data
		tableData = new ArrayList<TechnicalStatusByWeek>();
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 80.0, "Java Basics", "1"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 95.5, "OOP", "1"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 83.5, "Data Complexity", "2"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 92.0, "Logging", "3"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 89.0, "Threads", "3"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 79.5, "Garbage Collection", "3"));
		
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 80.0, "Java Basics", "1"));
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 95.5, "OOP", "1"));
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 83.5, "Data Complexity", "2"));
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 92.0, "Logging", "3"));
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 89.0, "Threads", "3"));
		tableData.add(new TechnicalStatusByWeek("2rUNwAAM", 79.5, "Garbage Collection", "3"));
		
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 80.0, "Java Basics", "1"));
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 95.5, "OOP", "1"));
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 83.5, "Data Complexity", "2"));
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 92.0, "Logging", "3"));
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 89.0, "Threads", "3"));
		tableData.add(new TechnicalStatusByWeek("2ehKRAAY", 79.5, "Garbage Collection", "3"));
		// end temp sample data
		
		return tableData;
	}
	
}
