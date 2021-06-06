package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TestingRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Testing;
import edu.coursework.enterprises.service.testing.impls.TestingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Testing controller API")
@RestController
@RequestMapping("api/testing")
public class TestingRestController {

    @Autowired
    TestingServiceImpl service;

    @GetMapping("/get/all")
    public List<Testing> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Testing getById(@PathVariable("id") String id){
        Testing byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Testing deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Testing create(@RequestBody Testing testing){
        return service.create(testing);
    }

    @PostMapping ("/update/")
    public Testing update(@RequestBody Testing testing){
        return service.update(testing);
    }
}
