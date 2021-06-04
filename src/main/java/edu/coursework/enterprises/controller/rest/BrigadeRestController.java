package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    BrigadeRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;
import edu.coursework.enterprises.service.brigade.impls.BrigadeServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Brigade controller API")
@RestController
@RequestMapping("api/brigade")
public class BrigadeRestController {

    @Autowired
    BrigadeServiceImpl service;

    @GetMapping("/get/all")
    public List<Brigade> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Brigade getById(@PathVariable("id") String id){
        Brigade byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Brigade deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Brigade create(@RequestBody Brigade brigade){
        return service.create(brigade);
    }

    @PostMapping ("/update/")
    public Brigade update(@RequestBody Brigade brigade){
        return service.update(brigade);
    }

    /*@GetMapping("/get/workers")
    public Object getEngineers(@PathVariable("plot") int plot){
        return service.get(plot) ;
    }*/
}
