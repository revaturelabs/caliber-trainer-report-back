package com.revature.data;

import com.revature.beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Category dao.
 */
@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    /**
     * Find category by name category.
     *
     * @param name the name
     * @return the category
     */
    Category findCategoryByName(String name);

}
