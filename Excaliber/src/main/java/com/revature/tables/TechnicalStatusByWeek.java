package com.revature.tables;

import java.util.Arrays;

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

/**
 * The type Technical status by week.
 */
public class TechnicalStatusByWeek {
	private String batchName;         // Name of the batch
	private Integer goodPercent;      // percentage of good technical status
	private Integer averagePercent;   // percentage of average technical status
	private Integer poorPercent;      // percentage of poor technical status
	private Integer superstarPercent; // percentage of super-star technical status
	private Integer nullPercent;      // percentage of null technical status
	private String[] categories;      // the categories the percentages represent
	private String week;              // the week evaluated
	
	/**
	 * Instantiates a new Technical status by week.
	 */
	public TechnicalStatusByWeek() {
		batchName = null;
		goodPercent = null;
		averagePercent = null;
		poorPercent = null;
		superstarPercent = null;
		nullPercent = null;
		categories = null;
		week = null;
	}

	public TechnicalStatusByWeek(String string, double d, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Integer getGoodPercent() {
		return goodPercent;
	}

	public void setGoodPercent(Integer goodPercent) {
		this.goodPercent = goodPercent;
	}

	public Integer getAveragePercent() {
		return averagePercent;
	}

	public void setAveragePercent(Integer averagePercent) {
		this.averagePercent = averagePercent;
	}

	public Integer getPoorPercent() {
		return poorPercent;
	}

	public void setPoorPercent(Integer poorPercent) {
		this.poorPercent = poorPercent;
	}

	public Integer getSuperstarPercent() {
		return superstarPercent;
	}

	public void setSuperstarPercent(Integer superstarPercent) {
		this.superstarPercent = superstarPercent;
	}

	public Integer getNullPercent() {
		return nullPercent;
	}

	public void setNullPercent(Integer nullPercent) {
		this.nullPercent = nullPercent;
	}

	public String[] getCategories() {
		return categories;
	}

	public void setCategories(String[] categories) {
		this.categories = categories;
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
		result = prime * result + ((averagePercent == null) ? 0 : averagePercent.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + Arrays.hashCode(categories);
		result = prime * result + ((goodPercent == null) ? 0 : goodPercent.hashCode());
		result = prime * result + ((nullPercent == null) ? 0 : nullPercent.hashCode());
		result = prime * result + ((poorPercent == null) ? 0 : poorPercent.hashCode());
		result = prime * result + ((superstarPercent == null) ? 0 : superstarPercent.hashCode());
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
		if (averagePercent == null) {
			if (other.averagePercent != null)
				return false;
		} else if (!averagePercent.equals(other.averagePercent))
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (!Arrays.equals(categories, other.categories))
			return false;
		if (goodPercent == null) {
			if (other.goodPercent != null)
				return false;
		} else if (!goodPercent.equals(other.goodPercent))
			return false;
		if (nullPercent == null) {
			if (other.nullPercent != null)
				return false;
		} else if (!nullPercent.equals(other.nullPercent))
			return false;
		if (poorPercent == null) {
			if (other.poorPercent != null)
				return false;
		} else if (!poorPercent.equals(other.poorPercent))
			return false;
		if (superstarPercent == null) {
			if (other.superstarPercent != null)
				return false;
		} else if (!superstarPercent.equals(other.superstarPercent))
			return false;
		if (week == null) {
			if (other.week != null)
				return false;
		} else if (!week.equals(other.week))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechnicalStatusByWeek [batchName=" + batchName + ", goodPercent=" + goodPercent + ", averagePercent="
				+ averagePercent + ", poorPercent=" + poorPercent + ", superstarPercent=" + superstarPercent
				+ ", nullPercent=" + nullPercent + ", categories=" + Arrays.toString(categories) + ", week=" + week
				+ "]";
	}

}
