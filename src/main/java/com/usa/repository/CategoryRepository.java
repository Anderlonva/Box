package com.usa.repository;

import com.usa.model.CategoryModel;
import com.usa.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<CategoryModel> getAllCategories() {

        return (List<CategoryModel>) categoryCrudRepository.findAll();
    }

    public Optional<CategoryModel> getCategory(Integer id) {
        return categoryCrudRepository.findById(id);
    }

    public CategoryModel saveCategory(CategoryModel categoryModel) {
        return categoryCrudRepository.save(categoryModel);
    }

    public boolean deleteCategory(Integer id) {
        categoryCrudRepository.deleteById(id);
        return true;
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
        return categoryCrudRepository.save(categoryModel);
    }
}
