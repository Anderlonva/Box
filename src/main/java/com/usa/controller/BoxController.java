package com.usa.controller;

import com.usa.model.BoxModel;
import com.usa.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Box")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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
    @ResponseStatus(HttpStatus.CREATED)
    public BoxModel saveBox(@RequestBody BoxModel boxModel){
        return  boxService.saveBox(boxModel);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBox(@PathVariable ("id")  Integer id){
        boxService.deleteBox(id);
        return true;
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoxModel updateBox(@RequestBody BoxModel boxModel){
        return boxService.updateBox(boxModel);
    }
}
