package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ProductRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Product;
import edu.coursework.enterprises.service.product.impls.ProductServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Product controller API")
@RestController
@RequestMapping("api/product")
public class ProductRestController {

    @Autowired
    ProductServiceImpl service;

    @GetMapping("/get/all")
    public List<Product> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Product getById(@PathVariable("id") String id){
        Product byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Product deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Product create(@RequestBody Product product){
        return service.create(product);
    }

    @PostMapping ("/update/")
    public Product update(@RequestBody Product product){
        return service.update(product);
    }

}
