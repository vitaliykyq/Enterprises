package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ShopRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Shop;
import edu.coursework.enterprises.service.shop.impls.ShopServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Shop controller API")
@RestController
@RequestMapping("api/shop")
public class ShopRestController {

    @Autowired
    ShopServiceImpl service;

    @GetMapping("/get/all")
    public List<Shop> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Shop getById(@PathVariable("id") String id){
        Shop byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Shop deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Shop create(@RequestBody Shop shop){
        return service.create(shop);
    }

    @PostMapping ("/update/")
    public Shop update(@RequestBody Shop shop){
        return service.update(shop);
    }

}
