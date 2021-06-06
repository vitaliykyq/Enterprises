package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    PlaneUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.model.Military;
import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.model.Transport;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import edu.coursework.enterprises.service.military.impls.MilitaryServiceImpl;
import edu.coursework.enterprises.service.plane.impls.PlaneServiceImpl;
import edu.coursework.enterprises.service.transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/plane")
@Controller
public class PlaneUIController {

    @Autowired
    PlaneServiceImpl planeService;

    @Autowired
    CivilServiceImpl civilService;

    @Autowired
    MilitaryServiceImpl militaryService;

    @Autowired
    TransportServiceImpl transportService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Plane> planeList = planeService.getAll();
        model.addAttribute("planeList", planeList);

        return "plane/planeList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Plane plane = planeService.getById(id);
        model.addAttribute("plane", plane);

        List<Civil> civilListId = civilService.getAll();
        model.addAttribute("civilListId", civilListId);

        List<Military> militaryListId = militaryService.getAll();
        model.addAttribute("militaryListId", militaryListId);

        List<Transport> transportListId = transportService.getAll();
        model.addAttribute("transportListId", transportListId);
        return "plane/updatePlane";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Plane plane = new Plane();
        model.addAttribute("plane", plane);

        List<Civil> civilListId = civilService.getAll();
        model.addAttribute("civilListId", civilListId);

        List<Military> militaryListId = militaryService.getAll();
        model.addAttribute("militaryListId", militaryListId);

        List<Transport> transportListId = transportService.getAll();
        model.addAttribute("transportListId", transportListId);
        return "plane/newPlane";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("plane") @RequestBody Plane plane) {

        planeService.update(plane);
        return "redirect:/ui/plane/get/all";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("plane") @RequestBody Plane plane) {
        model.addAttribute("plane", planeService.create(plane));
        return "redirect:/ui/plane/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        planeService.delete(id);
        return "redirect:/ui/plane/get/all";
    }
}
