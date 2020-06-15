package com.revature.beans;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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


    public Batch(String batchId, String batchName, String startDate, String endDate, String skill, String location) {
        this.batchId = batchId;
        this.batchName = batchName;
//		this.startDate = startDate;
//		this.endDate = endDate;
        this.skill = skill;
        this.location = location;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer exBatchId) {
        this.id = exBatchId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainer(int trainer) {
        this.trainerId = trainer;
    }

    public Set<Week> getWeeks() {
        return weeks;
    }

    public void setWeeks(Set<Week> weeks) {
        this.weeks = weeks;
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

}
