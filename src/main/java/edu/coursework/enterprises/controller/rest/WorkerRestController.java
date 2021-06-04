package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    WorkerRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Worker;
import edu.coursework.enterprises.service.worker.impls.WorkerServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Worker controller API")
@RestController
@RequestMapping("api/worker")
public class WorkerRestController {

    @Autowired
    WorkerServiceImpl service;

    @GetMapping("/get/all")
    public List<Worker> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Worker getById(@PathVariable("id") String id){
        Worker byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Worker deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Worker create(@RequestBody Worker worker){
        return service.create(worker);
    }

    @PostMapping ("/update/")
    public Worker update(@RequestBody Worker worker){
        return service.update(worker);
    }

}
