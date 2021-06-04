package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    MissileRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Missile;
import edu.coursework.enterprises.service.missile.impls.MissileServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Missile controller API")
@RestController
@RequestMapping("api/missile")
public class MissileRestController {

    @Autowired
    MissileServiceImpl service;

    @GetMapping("/get/all")
    public List<Missile> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Missile getById(@PathVariable("id") String id){
        Missile byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Missile deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Missile create(@RequestBody Missile missile){
        return service.create(missile);
    }

    @PostMapping ("/update/")
    public Missile update(@RequestBody Missile missile){
        return service.update(missile);
    }

}
