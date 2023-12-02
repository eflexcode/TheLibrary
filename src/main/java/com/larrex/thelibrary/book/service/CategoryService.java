package com.larrex.thelibrary.book.service;

import com.larrex.thelibrary.book.entity.Category;
import com.larrex.thelibrary.book.entity.model.CategoryModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    Category addCategory(CategoryModel categoryModel);

    Category updateCategory(CategoryModel categoryModel,Long id);

    Category getCategory(Long id);

    List<Category> getCategoryByName(String name, Pageable pageable);

    void deleteCategory(Long id);

}
