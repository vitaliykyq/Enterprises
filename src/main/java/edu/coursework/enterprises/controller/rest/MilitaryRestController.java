package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    MilitaryRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Military;
import edu.coursework.enterprises.service.military.impls.MilitaryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Military controller API")
@RestController
@RequestMapping("api/military")
public class MilitaryRestController {

    @Autowired
    MilitaryServiceImpl service;

    @GetMapping("/get/all")
    public List<Military> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Military getById(@PathVariable("id") String id){
        Military byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Military deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Military create(@RequestBody Military military){
        return service.create(military);
    }

    @PostMapping ("/update/")
    public Military update(@RequestBody Military military){
        return service.update(military);
    }

}
