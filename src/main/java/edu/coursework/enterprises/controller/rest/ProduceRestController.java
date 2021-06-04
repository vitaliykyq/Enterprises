package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ProduceRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Produce;
import edu.coursework.enterprises.service.produce.impls.ProduceServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Produce controller API")
@RestController
@RequestMapping("api/produce")
public class ProduceRestController {

    @Autowired
    ProduceServiceImpl service;

    @GetMapping("/get/all")
    public List<Produce> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Produce getById(@PathVariable("id") String id){
        Produce byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Produce deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Produce create(@RequestBody Produce produce){
        return service.create(produce);
    }

    @PostMapping ("/update/")
    public Produce update(@RequestBody Produce produce){
        return service.update(produce);
    }

}
