package com.usa.repository;

import com.usa.model.BoxModel;
import com.usa.repository.crudRepository.BoxCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoxRepository {

    @Autowired
    private BoxCrudRepository boxCrudRepository;

    public List<BoxModel> getAllBoxes(){
        return (List<BoxModel>) boxCrudRepository.findAll();
    }

    public Optional<BoxModel> getBox(Integer id){
        return boxCrudRepository.findById(id);
    }

    public BoxModel saveBox(BoxModel boxModel){
        return  boxCrudRepository.save(boxModel);
    }

    public boolean deleteBox(Integer id){
        boxCrudRepository.deleteById(id);
        return true;
    }

    public BoxModel updateBox(BoxModel boxModel){
        return boxCrudRepository.save(boxModel);
    }
}
