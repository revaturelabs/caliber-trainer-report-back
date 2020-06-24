package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Qcts category.
 */
public class QCTSCategory {
    private String categoryName;
    private List<BatchTSCategory> batches;

    /**
     * Instantiates a new Qcts category.
     */
    public QCTSCategory() {
        categoryName = "";
        batches = new ArrayList<BatchTSCategory>();
    }

    /**
     * Gets category name.
     *
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets category name.
     *
     * @param categoryName the category name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets batches.
     *
     * @return the batches
     */
    public List<BatchTSCategory> getBatches() {
        return batches;
    }

    /**
     * Sets batches.
     *
     * @param batches the batches
     */
    public void setBatches(List<BatchTSCategory> batches) {
        this.batches = batches;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((batches == null) ? 0 : batches.hashCode());
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QCTSCategory other = (QCTSCategory) obj;
        if (batches == null) {
            if (other.batches != null)
                return false;
        } else if (!batches.equals(other.batches))
            return false;
        if (categoryName == null) {
            return other.categoryName == null;
        } else return categoryName.equals(other.categoryName);
    }

    @Override
    public String toString() {
        return "QCTSCategory [categoryName=" + categoryName + ", batches=" + batches + "]";
    }


}
