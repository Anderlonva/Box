package com.usa.repository.crudRepository;

import com.usa.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
}
