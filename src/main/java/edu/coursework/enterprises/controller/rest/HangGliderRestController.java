package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    HangGliderRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.HangGlider;
import edu.coursework.enterprises.service.hangGlider.impls.HangGliderServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "HangGlider controller API")
@RestController
@RequestMapping("api/hangGlider")
public class HangGliderRestController {

    @Autowired
    HangGliderServiceImpl service;

    @GetMapping("/get/all")
    public List<HangGlider> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public HangGlider getById(@PathVariable("id") String id){
        HangGlider byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public HangGlider deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public HangGlider create(@RequestBody HangGlider hangGlider){
        return service.create(hangGlider);
    }

    @PostMapping ("/update/")
    public HangGlider update(@RequestBody HangGlider hangGlider){
        return service.update(hangGlider);
    }

}
