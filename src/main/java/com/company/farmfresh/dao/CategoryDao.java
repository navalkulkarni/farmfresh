package com.company.farmfresh.dao;

import com.company.farmfresh.model.Category;
import com.company.farmfresh.model.Item;

import java.util.List;

public interface CategoryDao {

    List<Category> getCategories();
}
