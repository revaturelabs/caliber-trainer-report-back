package com.revature.tables;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.revature.beans.Category;

/**
 * The type Assessment by category.
 */
public class AssessmentByCategory {
    private List<Category> categories;
    // Average is average score for category across all batches
    private List<Float[]> average;
    
    
    //Constructor
    public AssessmentByCategory() {
    	categories=new ArrayList<Category>();

    	average=new ArrayList<Float[]>();
    }
    
    //toString
    @Override
	public String toString() {
		return "AssessmentByCategory [categories=" + categories  + ", average=" + average + "]";
	}
	//Getters and Setters
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	public List<Float[]> getAverage() {
		return average;
	}
	public void setAverage(List<Float[]> average) {
		this.average = average;
	}
    
    

   

}
