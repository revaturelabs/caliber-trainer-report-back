package com.revature.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The type Batch.
 */
@Entity
@Table
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // our primary key
    @Column
    private String batchId; // key from caliber
    @Column
    private String batchName;
    @Column
    private Date startDate;
    @Column
    private Date endDate;
    @Column
    private String skill;
    @Column
    private String location;
    //private String type; // always Revature?
    @Column
    private int trainerId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "batch_week",
            joinColumns = @JoinColumn(name = "batch_id"),
            inverseJoinColumns = @JoinColumn(name = "week_id"))//need column names----------------------
    private Set<Week> weeks;

    /**
     * Instantiates a new Batch.
     */
    public Batch() {
        id = 0;
        this.batchId = "";
        batchName = "";
        this.startDate = null;
        this.endDate = null;
        this.skill = "";
        this.location = "";
        trainerId = 0;
        weeks = null;
    }


    /**
     * Instantiates a new Batch.
     *
     * @param batchId   the batch id
     * @param batchName the batch name
     * @param startDate the start date
     * @param endDate   the end date
     * @param skill     the skill
     * @param location  the location
     */
    public Batch(String batchId, String batchName, String startDate, String endDate, String skill, String location) {
        this.batchId = batchId;
        this.batchName = batchName;
//		this.startDate = startDate;
//		this.endDate = endDate;
        this.skill = skill;
        this.location = location;
    }


    @Override
    public String toString() {
        return "Batch{" +
                "id=" + id +
                ", batchId='" + batchId + '\'' +
                ", batchName='" + batchName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", skill='" + skill + '\'' +
                ", location='" + location + '\'' +
                ", trainer=" + trainerId +
                ", weeks=" + weeks +
                '}';
    }

    /**
     * Gets batchName.
     *
     * @return Value of batchName.
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * Sets new batchName.
     *
     * @param batchName New value of batchName.
     */
    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    /**
     * Gets location.
     *
     * @return Value of location.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets new location.
     *
     * @param location New value of location.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets weeks.
     *
     * @return Value of weeks.
     */
    public Set<Week> getWeeks() {
        return weeks;
    }

    /**
     * Sets new weeks.
     *
     * @param weeks New value of weeks.
     */
    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
    }

    /**
     * Gets skill.
     *
     * @return Value of skill.
     */
    public String getSkill() {
        return skill;
    }

    /**
     * Sets new skill.
     *
     * @param skill New value of skill.
     */
    public void setSkill(String skill) {
        this.skill = skill;
    }

    /**
     * Gets trainerId.
     *
     * @return Value of trainerId.
     */
    public int getTrainerId() {
        return trainerId;
    }

    /**
     * Sets new trainerId.
     *
     * @param trainerId New value of trainerId.
     */
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    /**
     * Gets endDate.
     *
     * @return Value of endDate.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets new endDate.
     *
     * @param endDate New value of endDate.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
     * Gets startDate.
     *
     * @return Value of startDate.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets new startDate.
     *
     * @param startDate New value of startDate.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
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
}
