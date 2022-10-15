package com.usa.service;

import com.usa.model.BoxModel;
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
        if (categoryModel.getId() == null){
            return  categoryRepository.saveCategory(categoryModel);
        }else {
            Optional<CategoryModel> optional= categoryRepository.getCategory(categoryModel.getId());
            if (optional.isEmpty()){
                return categoryRepository.saveCategory(categoryModel);
            }else {
                return categoryModel;
            }
        }
    }

    public boolean deleteCategory(Integer id) {
        Boolean aBoolean = getCategory(id).map(c -> {
            categoryRepository.deleteCategory(c.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public CategoryModel updateCategory(CategoryModel categoryModel) {
        if (categoryModel.getId() != null) {
            Optional<CategoryModel> optional = categoryRepository.getCategory(categoryModel.getId());
            if (!optional.isEmpty()){
                if (categoryModel.getName() != null) {
                    optional.get().setName(categoryModel.getName());
                }
                if (categoryModel.getDescription() != null) {
                    optional.get().setDescription(categoryModel.getDescription());
                }
                categoryRepository.saveCategory(optional.get());
                return optional.get();
            }else {
                return categoryModel;
            }
        }else {
            return categoryModel;
        }
    }
}
