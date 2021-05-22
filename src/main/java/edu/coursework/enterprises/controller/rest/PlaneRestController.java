package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlaneRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.service.plane.impls.PlaneServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Planes controller API")
@RestController
@RequestMapping("api/plane")
public class PlaneRestController {

    @Autowired
    PlaneServiceImpl service;

    @GetMapping("/get/all")
    public List<Plane> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Plane getById(@PathVariable("id") String id){
        Plane byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Plane deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Plane create(@RequestBody Plane plane){
        return service.create(plane);
    }

    @PostMapping ("/update/")
    public Plane update(@RequestBody Plane plane){
        return service.update(plane);
    }

}
