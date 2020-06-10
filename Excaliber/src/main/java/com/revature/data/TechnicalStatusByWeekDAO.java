package com.revature.data;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.tables.TechnicalStatusByWeek;

public class TechnicalStatusByWeekDAO {
	public Logger log = Logger.getLogger(TechnicalStatusByWeekDAO.class);
	
	public List<TechnicalStatusByWeek> getTableData(String batchId) {
		log.info("TechnicalStatusByWeekDAO: "
				+ "Getting table data for TechnicalStatusByWeek");
		List<TechnicalStatusByWeek> tableData = null;
		
		//TODO algorithm for getting data from DB 
		//and returning a List of TechnicalStatusByWeek objects
		
		//for each week
			// for each 
		
		// start temp sample data
		tableData = new ArrayList<TechnicalStatusByWeek>();
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 80.0, "Java Basics", "A"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 95.5, "OOP", "A"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 83.5, "Data Complexity", "B"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 92.0, "Logging", "1"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 89.0, "Threads", "1"));
		tableData.add(new TechnicalStatusByWeek("Ix2x2UAB", 79.5, "Garbage Collection", "1"));
		// end temp sample data
		
		return tableData;
	}
	
}
