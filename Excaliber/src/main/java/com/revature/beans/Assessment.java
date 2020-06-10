package com.revature.beans;

public class Assessment {
	private Integer assessmentId;
	private Integer scoreWeight; // how much the assessment score matters to the weekly average (raw score)
	private String type;
	//private Integer weekId;
	private Float average;
	private String skillCategory;

	public Assessment() {
		assessmentId = 0;
		scoreWeight = 0;
		type = "";
		//weekId = 0;
		average = (float) 0;
		skillCategory = "";
	}

	public Assessment(Integer scoreWeight, String type, Float average, String skillCategory) {
		this.assessmentId = assessmentId;
		this.scoreWeight = scoreWeight;
		this.type = type;
		this.average = average;
		this.skillCategory = skillCategory;
	}

	public Integer getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Integer assessmentId) {
		this.assessmentId = assessmentId;
	}

	public Integer getScoreWeight() {
		return scoreWeight;
	}
	public void setScoreWeight(Integer scoreWeight) {
		this.scoreWeight = scoreWeight;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*public Integer getWeekId() {
		return weekId;
	}
	public void setWeekId(Integer weekId) {
		this.weekId = weekId;
	}*/
	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public String getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(String skillCategory) {
		this.skillCategory = skillCategory;
	}

	@Override
	public String toString() {
		return "Assessment{" +
				"assessmentId=" + assessmentId +
				", scoreWeight=" + scoreWeight +
				", type='" + type + '\'' +
				", average=" + average +
				", skillCategory='" + skillCategory + '\'' +
				'}';
	}
}
