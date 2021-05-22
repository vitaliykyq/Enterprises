package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import edu.coursework.enterprises.service.plane.impls.PlaneServiceImpl;
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
        return "plane/updatePlane";
    }

    @PostMapping("/update")
    public String update(Model model,
                         @ModelAttribute("employee") @RequestBody Plane plane) {

        planeService.update(plane);
        return "redirect:/ui/plane/get/all";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Plane plane = new Plane();
        model.addAttribute("plane", plane);

        List<Civil> civilListId = civilService.getAll();
        model.addAttribute("civilListId", civilListId);
        return "plane/newPlane";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Plane plane) {

        String name = plane.getName();
        String planeModel = plane.getModel();
        Object type = plane.getType();
        /*plane.setCivil(civilService.getAll().get(Integer.parseInt(plane.getCivil().getId()) - 1));*/
        int issue = plane.getIssue();
        int aircrew = plane.getAircrew();
        int payload = plane.getPayload();
        double height = plane.getHeight();
        double length = plane.getLength();
        double wingspan = plane.getWingspan();
        double ceiling = plane.getCeiling();
        /*List<Plane> planes = planeService.getAll();*/

        if (name != null && name.length() > 0 && planeModel != null && planeModel.length() > 0
                && type != null
                && issue > 0 && aircrew > 0 && payload > 0
                && height > 0 && length > 0 && wingspan > 0 && ceiling > 0) {
            model.addAttribute("plane", planeService.create(plane));
            return "redirect:/ui/plane/get/all";
        }
        return "redirect:/ui/plane/showNewForm";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        planeService.delete(id);
        return "redirect:/ui/plane/get/all";
    }
}
