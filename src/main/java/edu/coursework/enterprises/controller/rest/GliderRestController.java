package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    GliderRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Glider;
import edu.coursework.enterprises.service.glider.impls.GliderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Glider controller API")
@RestController
@RequestMapping("api/glider")
public class GliderRestController {

    @Autowired
    GliderServiceImpl service;

    @GetMapping("/get/all")
    public List<Glider> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Glider getById(@PathVariable("id") String id){
        Glider byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Glider deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Glider create(@RequestBody Glider glider){
        return service.create(glider);
    }

    @PostMapping ("/update/")
    public Glider update(@RequestBody Glider glider){
        return service.update(glider);
    }

}
