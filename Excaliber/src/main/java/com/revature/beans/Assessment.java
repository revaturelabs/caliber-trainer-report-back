package com.revature.beans;

import javax.persistence.*;

/**
 * The type Assessment.
 */
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

    /**
     * Instantiates a new Assessment.
     */
    public Assessment() {
        id = 0;
        scoreWeight = 0;
        type = "";
        //weekId = 0;
        average = (float) 0;
        skillCategory = null;
    }

    /**
     * Instantiates a new Assessment.
     *
     * @param scoreWeight the score weight
     * @param type        the type
     * @param average     the average
     */
    public Assessment(Integer scoreWeight, String type, Float average) {
        this.scoreWeight = scoreWeight;
        this.type = type;
        this.average = average;
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

    /**
     * Gets skillCategory.
     *
     * @return Value of skillCategory.
     */
    public Category getSkillCategory() {
        return skillCategory;
    }

    /**
     * Sets new skillCategory.
     *
     * @param skillCategory New value of skillCategory.
     */
    public void setSkillCategory(Category skillCategory) {
        this.skillCategory = skillCategory;
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
     * Gets type.
     *
     * @return Value of type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets new type.
     *
     * @param type New value of type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets scoreWeight.
     *
     * @return Value of scoreWeight.
     */
    public Integer getScoreWeight() {
        return scoreWeight;
    }

    /**
     * Sets new scoreWeight.
     *
     * @param scoreWeight New value of scoreWeight.
     */
    public void setScoreWeight(Integer scoreWeight) {
        this.scoreWeight = scoreWeight;
    }

    /**
     * Gets average.
     *
     * @return Value of average.
     */
    public Float getAverage() {
        return average;
    }

    /**
     * Sets new average.
     *
     * @param average New value of average.
     */
    public void setAverage(Float average) {
        this.average = average;
    }
}
