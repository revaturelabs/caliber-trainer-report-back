package com.revature.beans;

import java.util.ArrayList;

public class BatchTSCategory {
	private String batchName;
	private QCTSScore score;
	//private ArrayList<Double> avgVal;
	
	public BatchTSCategory() {
		this.batchName = batchName;
		this.score = new QCTSScore();
		//this.avgVal = new ArrayList<Double>();
	}
	
	public BatchTSCategory(String categoryName, String batchName, ArrayList<Double> techScore, ArrayList<Double> avgVal) {
		this.batchName = batchName;
		this.score = new QCTSScore();
		//this.avgVal = new ArrayList<Double>();
	}

	
	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public void setScore(QCTSScore score) {
		this.score = score;
	}

	public QCTSScore getScore() {
		return score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((score == null) ? 0 : score.hashCode());
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
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (score == null) {
			if (other.score != null)
				return false;
		} else if (!score.equals(other.score))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchTSCategory [batchName=" + batchName + ", score=" + score + "]";
	}
	
	
	
}
