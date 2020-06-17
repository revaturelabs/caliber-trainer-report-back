package com.revature.beans;

public class QCTSScore {
	private Double good;
	private Double average;
	private Double poor;
	private Double superstar;
	private Double avgGood;
	private Double avgAverage;
	private Double avgPoor;
	private Double avgSuperstar;
	
	public QCTSScore() {
		good = 0.0;
		average = 0.0;
		poor = 0.0;
		superstar = 0.0;
		avgGood = 0.0;
		avgAverage = 0.0;
		avgPoor = 0.0;
		avgSuperstar = 0.0;
	}

	public Double getGood() {
		return good;
	}

	public void setGood(Double good) {
		this.good = good;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}

	public Double getPoor() {
		return poor;
	}

	public void setPoor(Double poor) {
		this.poor = poor;
	}

	public Double getSuperstar() {
		return superstar;
	}

	public void setSuperstar(Double superstar) {
		this.superstar = superstar;
	}

	public Double getAvgGood() {
		return avgGood;
	}

	public void setAvgGood(Double avgGood) {
		this.avgGood = avgGood;
	}

	public Double getAvgAverage() {
		return avgAverage;
	}

	public void setAvgAverage(Double avgAverage) {
		this.avgAverage = avgAverage;
	}

	public Double getAvgPoor() {
		return avgPoor;
	}

	public void setAvgPoor(Double avgPoor) {
		this.avgPoor = avgPoor;
	}

	public Double getAvgSuperstar() {
		return avgSuperstar;
	}

	public void setAvgSuperstar(Double avgSuperstar) {
		this.avgSuperstar = avgSuperstar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((average == null) ? 0 : average.hashCode());
		result = prime * result + ((avgAverage == null) ? 0 : avgAverage.hashCode());
		result = prime * result + ((avgGood == null) ? 0 : avgGood.hashCode());
		result = prime * result + ((avgPoor == null) ? 0 : avgPoor.hashCode());
		result = prime * result + ((avgSuperstar == null) ? 0 : avgSuperstar.hashCode());
		result = prime * result + ((good == null) ? 0 : good.hashCode());
		result = prime * result + ((poor == null) ? 0 : poor.hashCode());
		result = prime * result + ((superstar == null) ? 0 : superstar.hashCode());
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
		QCTSScore other = (QCTSScore) obj;
		if (average == null) {
			if (other.average != null)
				return false;
		} else if (!average.equals(other.average))
			return false;
		if (avgAverage == null) {
			if (other.avgAverage != null)
				return false;
		} else if (!avgAverage.equals(other.avgAverage))
			return false;
		if (avgGood == null) {
			if (other.avgGood != null)
				return false;
		} else if (!avgGood.equals(other.avgGood))
			return false;
		if (avgPoor == null) {
			if (other.avgPoor != null)
				return false;
		} else if (!avgPoor.equals(other.avgPoor))
			return false;
		if (avgSuperstar == null) {
			if (other.avgSuperstar != null)
				return false;
		} else if (!avgSuperstar.equals(other.avgSuperstar))
			return false;
		if (good == null) {
			if (other.good != null)
				return false;
		} else if (!good.equals(other.good))
			return false;
		if (poor == null) {
			if (other.poor != null)
				return false;
		} else if (!poor.equals(other.poor))
			return false;
		if (superstar == null) {
			if (other.superstar != null)
				return false;
		} else if (!superstar.equals(other.superstar))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QCTSScore [good=" + good + ", average=" + average + ", poor=" + poor + ", superstar=" + superstar
				+ ", avgGood=" + avgGood + ", avgAverage=" + avgAverage + ", avgPoor=" + avgPoor + ", avgSuperstar="
				+ avgSuperstar + "]";
	}
	
	
}
