package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    LaboratoryRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Laboratory;
import edu.coursework.enterprises.service.laboratory.impls.LaboratoryServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Laboratory controller API")
@RestController
@RequestMapping("api/laboratory")
public class LaboratoryRestController {

    @Autowired
    LaboratoryServiceImpl service;

    @GetMapping("/get/all")
    public List<Laboratory> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Laboratory getById(@PathVariable("id") String id){
        Laboratory byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Laboratory deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Laboratory create(@RequestBody Laboratory laboratory){
        return service.create(laboratory);
    }

    @PostMapping ("/update/")
    public Laboratory update(@RequestBody Laboratory laboratory){
        return service.update(laboratory);
    }

}
