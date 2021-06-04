package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    EngineerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Engineer;
import edu.coursework.enterprises.service.engineer.impls.EngineerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Engineer controller API")
@RestController
@RequestMapping("api/engineer")
public class EngineerRestController {

    @Autowired
    EngineerServiceImpl service;

    @GetMapping("/get/all")
    public List<Engineer> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Engineer getById(@PathVariable("id") String id){
        Engineer byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Engineer deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Engineer create(@RequestBody Engineer engineer){
        return service.create(engineer);
    }

    @PostMapping ("/update/")
    public Engineer update(@RequestBody Engineer engineer){
        return service.update(engineer);
    }

}
