package com.revature.beans;

import java.util.ArrayList;

public class BatchTSCategory {
	private String categoryName;
	private String batchId;
	private ArrayList<Double> techScore;
	private ArrayList<Double> avgVal;
	
	public BatchTSCategory() {
		this.categoryName = categoryName;
		this.batchId = batchId;
		this.techScore = new ArrayList<Double>();
		this.avgVal = new ArrayList<Double>();
	}
	
	public BatchTSCategory(String categoryName, String batchId, ArrayList<Double> techScore, ArrayList<Double> avgVal) {
		this.categoryName = categoryName;
		this.batchId = batchId;
		this.techScore = new ArrayList<Double>();
		this.avgVal = new ArrayList<Double>();
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public ArrayList<Double> getTechScore() {
		return techScore;
	}

	public void setTechScore(ArrayList<Double> techScore) {
		this.techScore = techScore;
	}

	public ArrayList<Double> getAvgVal() {
		return avgVal;
	}

	public void setAvgVal(ArrayList<Double> avgVal) {
		this.avgVal = avgVal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avgVal == null) ? 0 : avgVal.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + ((techScore == null) ? 0 : techScore.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchTSCategory other = (BatchTSCategory) obj;
		if (avgVal == null) {
			if (other.avgVal != null)
				return false;
		} else if (!avgVal.equals(other.avgVal))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (techScore == null) {
			if (other.techScore != null)
				return false;
		} else if (!techScore.equals(other.techScore))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchTSCategory [categoryName=" + categoryName + ", batchId=" + batchId + ", techScore=" + techScore
				+ ", avgVal=" + avgVal + "]";
	}
	
	
	
}
