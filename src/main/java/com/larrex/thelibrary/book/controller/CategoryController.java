package com.larrex.thelibrary.book.controller;

import com.larrex.thelibrary.book.entity.Category;
import com.larrex.thelibrary.book.entity.model.CategoryModel;
import com.larrex.thelibrary.book.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/v1")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category createCategory(@RequestBody CategoryModel categoryModel){
       return categoryService.addCategory(categoryModel);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id ,@RequestBody CategoryModel categoryModel){
        return categoryService.updateCategory(categoryModel,id);
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @GetMapping("/query")
    public List<Category> getCategoryById(@RequestParam(name = "name") String name, Pageable pageable){
        return categoryService.getCategoryByName(name,pageable);
    }

}
