package com.revature.tables;

/* Technical Status By Week

User Story:
  Percent of each QC technical status according to the 
  categories assigned to a particular week.
  
Objective:
  Determine trainer consistencies by using QC scores for a week in particular.
  (a group of categories -> i.e. Week 4 is Servlets/Angular).
 
Note: Using a Set of TechnicalStatusByWeek objects, 
      a graph could group data points by week
      and display the percentage of each category.
*/

public class TechnicalStatusByWeek {
	private String batchName;    // Name of the batch
	private Double percentage; // percentage of technical status in a category
	private String category;   // the category the percentage represents
	private String week;       // the week percentage/category refer to

	public TechnicalStatusByWeek() {
		batchName = null;
		percentage = null;
		category = "";
		week = "";
	}

	public TechnicalStatusByWeek(String batchName, Double percentage, String category, String week) {
		this.batchName = batchName;
		this.percentage = percentage;
		this.category = category;
		this.week = week;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((percentage == null) ? 0 : percentage.hashCode());
		result = prime * result + ((week == null) ? 0 : week.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TechnicalStatusByWeek))
			return false;
		TechnicalStatusByWeek other = (TechnicalStatusByWeek) obj;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (percentage == null) {
			if (other.percentage != null)
				return false;
		} else if (!percentage.equals(other.percentage))
			return false;
		if (week == null) {
			return other.week == null;
		} else return week.equals(other.week);
	}

	@Override
	public String toString() {
		return "TechnicalStatusByWeek [batchName=" + batchName + ", percentage=" + percentage + ", category=" + category
				+ ", week=" + week + "]";
	}

}
