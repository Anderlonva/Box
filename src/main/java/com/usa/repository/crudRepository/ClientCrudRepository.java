package com.usa.repository.crudRepository;

import com.usa.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {
}
