package com.revature.tables;

/* Technical Status By Week
User Story:
  Percent of each QC technical status according to the 
  categories assigned to a particular week.
  
Objective:
  Determine trainer consistencies by using QC scores for a week in particular.
  (a group of categories -> i.e. Week 4 is Servlets/Angular).
*/

/**
 * The type Technical status by week.
 */
public class TechnicalStatusByWeek {
	private String category;        // category of technical status
	private Integer nullCount;      // number of null technical status
	private Integer poorCount;      // number of poor technical status
	private Integer averageCount;   // number of average technical status
	private Integer goodCount;      // number of good technical status
	private Integer superstarCount; // number of super-star technical status
	private Double nullAvg;        // average of null technical status
	private Double poorAvg;        // average of poor technical status
	private Double averageAvg;     // average of average technical status
	private Double goodAvg;        // average of good technical status
	private Double superstarAvg;   // average of super-star technical status
	
	/**
	 * Instantiates a new Technical status by week.
	 */
	public TechnicalStatusByWeek() {
		category = "unknown";
		nullCount = 0;
		poorCount = 0;
		averageCount = 0;
		goodCount = 0;
		superstarCount = 0;
		nullAvg = 0.0;
		poorAvg = 0.0;
		averageAvg = 0.0;
		goodAvg = 0.0;
		superstarAvg = 0.0;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getNullCount() {
		return nullCount;
	}

	public void setNullCount(Integer nullCount) {
		this.nullCount = nullCount;
	}

	public Integer getPoorCount() {
		return poorCount;
	}

	public void setPoorCount(Integer poorCount) {
		this.poorCount = poorCount;
	}

	public Integer getAverageCount() {
		return averageCount;
	}

	public void setAverageCount(Integer averageCount) {
		this.averageCount = averageCount;
	}

	public Integer getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(Integer goodCount) {
		this.goodCount = goodCount;
	}

	public Integer getSuperstarCount() {
		return superstarCount;
	}

	public void setSuperstarCount(Integer superstarCount) {
		this.superstarCount = superstarCount;
	}

	public Double getNullAvg() {
		return nullAvg;
	}

	public void setNullAvg(Double nullAvg) {
		this.nullAvg = nullAvg;
	}

	public Double getPoorAvg() {
		return poorAvg;
	}

	public void setPoorAvg(Double poorAvg) {
		this.poorAvg = poorAvg;
	}

	public Double getAverageAvg() {
		return averageAvg;
	}

	public void setAverageAvg(Double averageAvg) {
		this.averageAvg = averageAvg;
	}

	public Double getGoodAvg() {
		return goodAvg;
	}

	public void setGoodAvg(Double goodAvg) {
		this.goodAvg = goodAvg;
	}

	public Double getSuperstarAvg() {
		return superstarAvg;
	}

	public void setSuperstarAvg(Double superstarAvg) {
		this.superstarAvg = superstarAvg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averageAvg == null) ? 0 : averageAvg.hashCode());
		result = prime * result + ((averageCount == null) ? 0 : averageCount.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((goodAvg == null) ? 0 : goodAvg.hashCode());
		result = prime * result + ((goodCount == null) ? 0 : goodCount.hashCode());
		result = prime * result + ((nullAvg == null) ? 0 : nullAvg.hashCode());
		result = prime * result + ((nullCount == null) ? 0 : nullCount.hashCode());
		result = prime * result + ((poorAvg == null) ? 0 : poorAvg.hashCode());
		result = prime * result + ((poorCount == null) ? 0 : poorCount.hashCode());
		result = prime * result + ((superstarAvg == null) ? 0 : superstarAvg.hashCode());
		result = prime * result + ((superstarCount == null) ? 0 : superstarCount.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof TechnicalStatusByWeek))
			return false;
		TechnicalStatusByWeek other = (TechnicalStatusByWeek) obj;
		if (averageAvg == null) {
			if (other.averageAvg != null)
				return false;
		} else if (!averageAvg.equals(other.averageAvg))
			return false;
		if (averageCount == null) {
			if (other.averageCount != null)
				return false;
		} else if (!averageCount.equals(other.averageCount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (goodAvg == null) {
			if (other.goodAvg != null)
				return false;
		} else if (!goodAvg.equals(other.goodAvg))
			return false;
		if (goodCount == null) {
			if (other.goodCount != null)
				return false;
		} else if (!goodCount.equals(other.goodCount))
			return false;
		if (nullAvg == null) {
			if (other.nullAvg != null)
				return false;
		} else if (!nullAvg.equals(other.nullAvg))
			return false;
		if (nullCount == null) {
			if (other.nullCount != null)
				return false;
		} else if (!nullCount.equals(other.nullCount))
			return false;
		if (poorAvg == null) {
			if (other.poorAvg != null)
				return false;
		} else if (!poorAvg.equals(other.poorAvg))
			return false;
		if (poorCount == null) {
			if (other.poorCount != null)
				return false;
		} else if (!poorCount.equals(other.poorCount))
			return false;
		if (superstarAvg == null) {
			if (other.superstarAvg != null)
				return false;
		} else if (!superstarAvg.equals(other.superstarAvg))
			return false;
		if (superstarCount == null) {
			if (other.superstarCount != null)
				return false;
		} else if (!superstarCount.equals(other.superstarCount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TechnicalStatusByWeek [category=" + category + ", nullCount=" + nullCount + ", poorCount=" + poorCount
				+ ", averageCount=" + averageCount + ", goodCount=" + goodCount + ", superstarCount=" + superstarCount
				+ ", nullAvg=" + nullAvg + ", poorAvg=" + poorAvg + ", averageAvg=" + averageAvg + ", goodAvg="
				+ goodAvg + ", superstarAvg=" + superstarAvg + "]";
	}

}
