package com.revature.tables;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AssessScoresByCategoryAllBatches {
	private List<Integer> aScores; //assessment scores for each week
	private List<String> batchNames; //corresponding batch names
	private List<Integer> batchId;
	private String aType; //type of assessment: test, verbal, project etc.
	
	//add dates maybe?
	//private List<Date> startDates; //corresponding start dates
	
	
	//two constructors
	public AssessScoresByCategoryAllBatches() {
		aScores=new ArrayList<Integer>();
		batchNames=new ArrayList<String>();
		batchId=new ArrayList<Integer>();
		aType="";
	}
	


	public AssessScoresByCategoryAllBatches(ArrayList<Integer> aScores, ArrayList<Integer> batchId, 
											ArrayList<String> batchNames, String aType) 
	{
		
		this.aScores=aScores;
		this.batchNames=batchNames;
		this.batchId=batchId;
		this.aType=aType;
	}
	
	//Getters and Setters
	public List<Integer> getaScores() {
		return aScores;
	}
	public void setaScores(List<Integer> aScores) {
		this.aScores = aScores;
	}
	public List<String> getBatchNames() {
		return batchNames;
	}
	public void setBatchNames(List<String> batchNames) {
		this.batchNames = batchNames;
	}
	public List<Integer> getBatchId() {
		return batchId;
	}
	public void setBatchId(List<Integer> batchId) {
		this.batchId = batchId;
	}
	public String getaType() {
		return aType;
	}
	public void setaType(String aType) {
		this.aType = aType;
	}
	
	
	@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [aScores=" + aScores + ", batchNames=" + batchNames + ", batchId="
				+ batchId + ", aType=" + aType + "]";
	}
	
	
}
