package com.usa.repository.crudRepository;

import com.usa.model.CategoryModel;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<CategoryModel, Integer> {
}
