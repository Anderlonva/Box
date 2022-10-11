package com.usa.service;

import com.usa.model.BoxModel;
import com.usa.repository.BoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoxService {

    @Autowired
    private BoxRepository boxRepository;

    public List<BoxModel> getAllBoxes(){
        return (List<BoxModel>) boxRepository.getAllBoxes();
    }

    public Optional<BoxModel> getBox(Integer id){
        return boxRepository.getBox(id);
    }

    public BoxModel saveBox(BoxModel boxModel){
        return  boxRepository.saveBox(boxModel);
    }

    public boolean deleteBox(Integer id){
        boxRepository.deleteBox(id);
        return true;
    }

    public BoxModel updateBox(BoxModel boxModel){
        return boxRepository.updateBox(boxModel);
    }
}
