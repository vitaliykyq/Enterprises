package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.*;
import edu.coursework.enterprises.service.brigade.impls.BrigadeServiceImpl;
import edu.coursework.enterprises.service.engineer.impls.EngineerServiceImpl;
import edu.coursework.enterprises.service.plot.impls.PlotServiceImpl;
import edu.coursework.enterprises.service.produce.impls.ProduceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/plot")
@Controller
public class PlotUIController {

    @Autowired
    PlotServiceImpl plotService;

    @Autowired
    ProduceServiceImpl produceService;

    @Autowired
    EngineerServiceImpl engineerService;

    @Autowired
    BrigadeServiceImpl brigadeService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Plot> plotList = plotService.getAll();
        model.addAttribute("plotList", plotList);

        return "plot/plotList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Plot plot = plotService.getById(id);
        model.addAttribute("plot",plot);

        List<Produce> produceListId = produceService.getAll();
        model.addAttribute("produceListId", produceListId);

        List<Engineer> engineerListId = engineerService.getAll();
        model.addAttribute("engineerListId", engineerListId);

        List<Brigade> brigadeListId = brigadeService.getAll();
        model.addAttribute("brigadeListId", brigadeListId);
        return "plot/updatePlot";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Plot plot = new Plot();
        model.addAttribute("plot", plot);

        List<Produce> produceListId = produceService.getAll();
        model.addAttribute("produceListId", produceListId);

        List<Engineer> engineerListId = engineerService.getAll();
        model.addAttribute("engineerListId", engineerListId);

        List<Brigade> brigadeListId = brigadeService.getAll();
        model.addAttribute("brigadeListId", brigadeListId);
        return "plot/newPlot";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("plot") @RequestBody Plot plot) {
        model.addAttribute("plot", plotService.create(plot));
        return "redirect:/ui/plot/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("plot") @RequestBody Plot plot) {

        plotService.update(plot);
        return "redirect:/ui/plot/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        plotService.delete(id);
        return "redirect:/ui/plot/get/all";
    }
}
