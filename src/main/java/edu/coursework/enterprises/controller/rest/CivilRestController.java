package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilRestController 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Civil controller API")
@RestController
@RequestMapping("api/civil")
public class CivilRestController {

    @Autowired
    CivilServiceImpl service;

    @GetMapping("/get/all")
    public List<Civil> getCivil(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Civil getById(@PathVariable("id") String id){
        Civil byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Civil deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Civil create(@RequestBody Civil civil){
        return service.create(civil);
    }

    @PostMapping ("/update/")
    public Civil update(@RequestBody Civil civil){
        return service.update(civil);
    }

}
