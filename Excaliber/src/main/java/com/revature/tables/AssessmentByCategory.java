package com.revature.tables;

import com.revature.beans.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assessment by category.
 */
public class AssessmentByCategory {
    private List<Category> categories;
    // Average is average score for category across all batches
    private List<Float[]> average;


    /**
     * Instantiates a new Assessment by category.
     */
//Constructor
    public AssessmentByCategory() {
        categories = new ArrayList<Category>();

        average = new ArrayList<Float[]>();
    }

    //toString
    @Override
    public String toString() {
        return "AssessmentByCategory [categories=" + categories + ", average=" + average + "]";
    }

    /**
     * Gets categories.
     *
     * @return the categories
     */
//Getters and Setters
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }


    /**
     * Gets average.
     *
     * @return the average
     */
    public List<Float[]> getAverage() {
        return average;
    }

    /**
     * Sets average.
     *
     * @param average the average
     */
    public void setAverage(List<Float[]> average) {
        this.average = average;
    }


}
