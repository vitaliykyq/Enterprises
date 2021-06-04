package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PersonRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Person;
import edu.coursework.enterprises.service.person.impls.PersonServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Person controller API")
@RestController
@RequestMapping("api/person")
public class PersonRestController {

    @Autowired
    PersonServiceImpl service;

    @GetMapping("/get/all")
    public List<Person> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Person getById(@PathVariable("id") String id){
        Person byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Person deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @PostMapping ("/update/")
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

}
