package com.revature.beans;

import javax.persistence.*;

import java.util.List;
import java.util.Set;

/**
 * The type Week.
 */
@Entity
@Table
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String weekNumber; // what number week they are in; could be A or B for extended batches
    @Column
    private String batchId;
    @Column
    private String technicalStatus;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "week_category",
            joinColumns = @JoinColumn(name = "week_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "week_assessment",
            joinColumns = @JoinColumn(name = "week_id"),
            inverseJoinColumns = @JoinColumn(name = "assessment_id"))
    private List<Assessment> assessments;


    /**
     * Instantiates a new Week.
     */
    public Week() {
        id = 0;
        weekNumber = "";
        batchId = "";
        technicalStatus = "";
        categories = null;
        assessments = null;
    }

    /**
     * Instantiates a new Week.
     *
     * @param weekNumber      the week number
     * @param technicalStatus the technical status
     */
    public Week(String weekNumber, String technicalStatus) {
        this.weekNumber = weekNumber;
        this.technicalStatus = technicalStatus;
    }

    /**
     * Gets technicalStatus.
     *
     * @return Value of technicalStatus.
     */
    public String getTechnicalStatus() {
        return technicalStatus;
    }

    /**
     * Sets new technicalStatus.
     *
     * @param technicalStatus New value of technicalStatus.
     */
    public void setTechnicalStatus(String technicalStatus) {
        this.technicalStatus = technicalStatus;
    }

    /**
     * Gets weekNumber.
     *
     * @return Value of weekNumber.
     */
    public String getWeekNumber() {
        return weekNumber;
    }

    /**
     * Sets new weekNumber.
     *
     * @param weekNumber New value of weekNumber.
     */
    public void setWeekNumber(String weekNumber) {
        this.weekNumber = weekNumber;
    }

    /**
     * Gets batchId.
     *
     * @return Value of batchId.
     */
    public String getBatchId() {
        return batchId;
    }

    /**
     * Sets new batchId.
     *
     * @param batchId New value of batchId.
     */
    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    /**
     * Gets assessments.
     *
     * @return Value of assessments.
     */
    public List<Assessment> getAssessments() {
        return assessments;
    }

    /**
     * Sets new assessments.
     *
     * @param assessments New value of assessments.
     */
    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id New value of id.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets categories.
     *
     * @return Value of categories.
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Sets new categories.
     *
     * @param categories New value of categories.
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
