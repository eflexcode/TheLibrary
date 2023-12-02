package com.larrex.thelibrary.book.serviceImpl;

import com.larrex.thelibrary.book.entity.Category;
import com.larrex.thelibrary.book.entity.model.CategoryModel;
import com.larrex.thelibrary.book.repository.CategoryRepository;
import com.larrex.thelibrary.book.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category addCategory(CategoryModel categoryModel) {

        Category category = new Category();
        BeanUtils.copyProperties(categoryModel,category);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryModel categoryModel,Long id) {

        Category category = getCategory(id);
        category.setCategoryName(categoryModel.getCategoryName() != null ? categoryModel.getCategoryName() : category.getCategoryName());

        return categoryRepository.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,""));
    }

    @Override
    public List<Category> getCategoryByName(String name, Pageable pageable) {
        return categoryRepository.findByCategoryNameContainingIgnoreCase(name,pageable).toList();
    }

    @Override
    public void deleteCategory(Long id) {

    }
}
