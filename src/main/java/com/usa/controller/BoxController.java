package com.usa.controller;

import com.usa.model.BoxModel;
import com.usa.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins = "*")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<BoxModel> getAllBoxes(){
        return  boxService.getAllBoxes();
    }

    @GetMapping("/{id}")
    public Optional<BoxModel> getBox(@PathVariable ("id")  Integer id){
        return boxService.getBox(id);
    }

    @PostMapping("/save")
    public BoxModel saveBox(@RequestBody BoxModel boxModel){
        return  boxService.saveBox(boxModel);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBox(@PathVariable ("id")  Integer id){
        boxService.deleteBox(id);
        return true;
    }

    @PutMapping("/update")
    public BoxModel updateBox(@RequestBody BoxModel boxModel){
        return boxService.updateBox(boxModel);
    }
}
