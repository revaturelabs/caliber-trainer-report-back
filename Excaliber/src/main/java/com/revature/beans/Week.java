package com.revature.beans;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Week {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "weekNumber")
	private String weekNumber; // what number week they are in; could be A or B for extended batches
	@Column(name = "batchId")
	private String batchId;
	@Column(name = "technicalStatus")
	private String technicalStatus;


	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "week_category",
			joinColumns = @JoinColumn(name = "week_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name="week_assessment",
			joinColumns=@JoinColumn(name="week_id"),
			inverseJoinColumns=@JoinColumn(name="assessment_id"))
	private Set<Assessment> assessments; 


	public Week() {
		id = 0;
		weekNumber = "";
		batchId = "";
		technicalStatus = "";
		categories = null;
		assessments = null;
	}

	public Week(String weekNumber, String technicalStatus) {
		this.id = id;
		this.weekNumber = weekNumber;
		this.batchId = batchId;
		this.technicalStatus = technicalStatus;
		// TODO categories;
		// TODO assessments
		// TODO batchId
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWeekNumber() {
		return weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getTechnicalStatus() {
		return technicalStatus;
	}

	public void setTechnicalStatus(String technicalStatus) {
		this.technicalStatus = technicalStatus;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Set<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(Set<Assessment> assessments) {
		this.assessments = assessments;
	}

	@Override
	public String toString() {
		return "Week{" +
				"id=" + id +
				", weekNumber='" + weekNumber + '\'' +
				", batchId=" + batchId +
				", technicalStatus='" + technicalStatus + '\'' +
				", categories=" + categories +
				", assessments=" + assessments +
				'}';
	}
}
