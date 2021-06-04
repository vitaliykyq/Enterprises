package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    TransportRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Transport;
import edu.coursework.enterprises.service.transport.impls.TransportServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Transport controller API")
@RestController
@RequestMapping("api/transport")
public class TransportRestController {

    @Autowired
    TransportServiceImpl service;

    @GetMapping("/get/all")
    public List<Transport> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Transport getById(@PathVariable("id") String id){
        Transport byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Transport deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Transport create(@RequestBody Transport transport){
        return service.create(transport);
    }

    @PostMapping ("/update/")
    public Transport update(@RequestBody Transport transport){
        return service.update(transport);
    }

}
