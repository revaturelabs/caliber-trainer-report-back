package com.revature.tables;

import com.revature.beans.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assessment by category.
 */
public class AssessmentByCategory {
    private String category;

    private Float[] average;


    /**
     * Instantiates a new Assessment by category.
     */
//Constructor
    public AssessmentByCategory() {
        category = "";

        average = new Float[5];
    }

    //toString
    @Override
    public String toString() {
        return "AssessmentByCategory [category=" + category+ ", average=" + average + "]";
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
//Getters and Setters
    public String getCategory() {
        return category;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategory(String category) {
        this.category = category;
    }


    /**
     * Gets average.
     *
     * @return the average
     */
    public Float[] getAverage() {
        return average;
    }

    /**
     * Sets average.
     *
     * @param average the average
     */
    public void setAverage( Float[] average) {
        this.average = average;
    }


}
