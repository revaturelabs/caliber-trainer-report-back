package com.revature.beans;

import javax.persistence.*;

@Entity
@Table
public class Assessment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "score_weight")
	private Integer scoreWeight; // how much the assessment score matters to the weekly average (raw score)
	@Column(name = "type0")
	private String type;
	//private Integer weekId;
	@Column
	private Float average;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id") //need column name------------------------------------------------
	private Category skillCategory;

	public Assessment() {
		id = 0;
		scoreWeight = 0;
		type = "";
		//weekId = 0;
		average = (float) 0;
		skillCategory = null;
	}

	public Assessment(Integer scoreWeight, String type, Float average) {
		this.scoreWeight = scoreWeight;
		this.type = type;
		this.average = average;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Category getSkillCategory() {
		return skillCategory;
	}

	public void setSkillCategory(Category skillCategory) {
		this.skillCategory = skillCategory;
	}

	@Override
	public String toString() {
		return "Assessment{" +
				"id=" + id +
				", scoreWeight=" + scoreWeight +
				", type='" + type + '\'' +
				", average=" + average +
				", skillCategory='" + skillCategory + '\'' +
				'}';
	}
}
