package edu.coursework.enterprises.controller.rest;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlotRestController
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plot;
import edu.coursework.enterprises.service.plot.impls.PlotServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*http://localhost:8080/api/civil/get/all*/
@Tag(name = "Plot controller API")
@RestController
@RequestMapping("api/plot")
public class PlotRestController {

    @Autowired
    PlotServiceImpl service;

    @GetMapping("/get/all")
    public List<Plot> getAll(){
        return service.getAll() ;
    }

    @GetMapping("/get/{id}")
    public Plot getById(@PathVariable("id") String id){
        Plot byId = service.getById(id);
        return byId;
    }

    @GetMapping("/delete/{id}")
    public Plot deleteById(@PathVariable("id") String id){
        return service.delete(id);
    }

    @PostMapping ("/create/")
    public Plot create(@RequestBody Plot plot){
        return service.create(plot);
    }

    @PostMapping ("/update/")
    public Plot update(@RequestBody Plot plot){
        return service.update(plot);
    }

    @GetMapping("/get/productFromPlot")
    public Object getProductFromPlot(@PathVariable("plot") int plot){
        return service.getProductFromPlot(plot) ;
    }

}
