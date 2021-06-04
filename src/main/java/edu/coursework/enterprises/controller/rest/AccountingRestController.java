package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    AccountingRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Accounting;
import edu.coursework.enterprises.service.accounting.impls.AccountingServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Accounting controller API")
@RestController
@RequestMapping("api/accounting")
public class AccountingRestController {

    @Autowired
    AccountingServiceImpl service;

    @GetMapping("/get/all")
    public List<Accounting> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Accounting getById(@PathVariable("id") String id){
        Accounting byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Accounting deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Accounting create(@RequestBody Accounting accounting){
        return service.create(accounting);
    }

    @PostMapping ("/update/")
    public Accounting update(@RequestBody Accounting accounting){
        return service.update(accounting);
    }

}
