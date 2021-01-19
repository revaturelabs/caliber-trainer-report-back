package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Assess scores by category all batches.
 */
public class AssessScoresByCategoryAllBatches {
	private List<CategoryBatches> categories; //type of assessment: test, verbal, project etc.

	/**
	 * Instantiates a new Assess scores by category all batches.
	 */
//two constructors
	public AssessScoresByCategoryAllBatches() {
		categories = new ArrayList<>();
	}


	/**
	 * Instantiates a new Assess scores by category all batches.
	 *
	 * @param categories the categories
	 */
	public AssessScoresByCategoryAllBatches(List<CategoryBatches> categories) {
		this.categories = categories;
	}

	/**
	 * Gets categories.
	 *
	 * @return the categories
	 */
	public List<CategoryBatches> getCategories() {
		return categories;
	}


	/**
	 * Sets categories.
	 *
	 * @param categories the categories
	 */
	public void setCategories(List<CategoryBatches> categories) {
		this.categories = categories;
	}


	@Override
	public String toString() {
		return "AssessScoresByCategoryAllBatches [categories=" + categories + "]";
	}
}
