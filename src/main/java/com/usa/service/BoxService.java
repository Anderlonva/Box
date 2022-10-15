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
        if (boxModel.getId() == null){
            return  boxRepository.saveBox(boxModel);
        }else {
            Optional<BoxModel> optional= boxRepository.getBox(boxModel.getId());
            if (optional.isEmpty()){
                return boxRepository.saveBox(boxModel);
            }else {
                return boxModel;
            }
        }
    }

    public boolean deleteBox(Integer id){
        Boolean aBoolean = getBox(id).map(b -> {
            boxRepository.deleteBox(b.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public BoxModel updateBox(BoxModel boxModel){
        if (boxModel.getId() != null) {
            Optional<BoxModel> optional = boxRepository.getBox(boxModel.getId());
            if (!optional.isEmpty()){
                if (boxModel.getName() != null) {
                    optional.get().setName(boxModel.getName());
                }
                if (boxModel.getLocation() != null) {
                    optional.get().setLocation(boxModel.getLocation());
                }
                if (boxModel.getCapacity() != null) {
                    optional.get().setCapacity(boxModel.getCapacity());
                }
                if (boxModel.getDescription() != null) {
                    optional.get().setDescription(boxModel.getDescription());
                }
                if (boxModel.getCategory() != null) {
                    optional.get().setCategory(boxModel.getCategory());
                }
                optional.get().setMessages(boxModel.getMessages());
                boxRepository.saveBox(optional.get());
                return optional.get();
            }else {
                return boxModel;
            }
        }else {
            return boxModel;
        }
    }
}
