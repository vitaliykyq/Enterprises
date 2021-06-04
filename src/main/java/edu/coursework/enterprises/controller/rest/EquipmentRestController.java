package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    EquipmentRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Equipment;
import edu.coursework.enterprises.service.equipment.impls.EquipmentServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Equipment controller API")
@RestController
@RequestMapping("api/equipment")
public class EquipmentRestController {

    @Autowired
    EquipmentServiceImpl service;

    @GetMapping("/get/all")
    public List<Equipment> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Equipment getById(@PathVariable("id") String id){
        Equipment byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Equipment deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Equipment create(@RequestBody Equipment equipment){
        return service.create(equipment);
    }

    @PostMapping ("/update/")
    public Equipment update(@RequestBody Equipment equipment){
        return service.update(equipment);
    }

}
