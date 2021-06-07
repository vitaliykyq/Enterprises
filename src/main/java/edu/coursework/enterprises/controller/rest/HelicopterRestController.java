package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    HelicopterRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Helicopter;
import edu.coursework.enterprises.service.helicopter.impls.HelicopterServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Helicopter controller API")
@RestController
@RequestMapping("api/helicopter")
public class HelicopterRestController {

    @Autowired
    HelicopterServiceImpl service;

    @GetMapping("/get/all")
    public List<Helicopter> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Helicopter getById(@PathVariable("id") String id){
        Helicopter byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Helicopter deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Helicopter create(@RequestBody Helicopter helicopter){
        return service.create(helicopter);
    }

    @PostMapping ("/update/")
    public Helicopter update(@RequestBody Helicopter helicopter){
        return service.update(helicopter);
    }

    @GetMapping("/get/amountOfHelicoptersOfModel/{model}")
    public Object getAmountOfHelicoptersOfModel(@PathVariable("model") String model){
        return service.getAmountOfHelicoptersOfModel(model);
    }

    @GetMapping("/get/amountOfHelicoptersOfEveryModel")
    public Object getAmountOfHelicoptersOfEveryModel(){
        return service.getAmountOfHelicoptersOfEveryModel();
    }

    @GetMapping("/get/allByModel/{model}")
    public Object getAllByModel(@PathVariable("model") String model){
        return service.getAllByModel(model);
    }

    @GetMapping("/get/allByName/{name}")
    public Object getAllByName(@PathVariable("name") String name){
        return service.getAllByName(name);
    }

}
