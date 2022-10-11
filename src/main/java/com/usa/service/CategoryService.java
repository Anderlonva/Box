package com.usa.service;

import com.usa.model.CategoryModel;
import com.usa.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> getAllCategories() {

        return (List<CategoryModel>) categoryRepository.getAllCategories() ;
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryRepository.getCategory(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryRepository.saveCategory(categoryModel);
    }

    public boolean deleteCategory(Integer id) {
        categoryRepository.deleteCategory(id);
        return true;
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
        return categoryRepository.updateCategory(categoryModel);
    }
}
