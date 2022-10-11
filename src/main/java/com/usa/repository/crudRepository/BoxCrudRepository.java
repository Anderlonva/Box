package com.usa.repository.crudRepository;

import com.usa.model.BoxModel;
import org.springframework.data.repository.CrudRepository;

public interface BoxCrudRepository extends CrudRepository<BoxModel, Integer> {
}
