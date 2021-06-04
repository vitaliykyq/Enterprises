package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Glider;
import edu.coursework.enterprises.service.glider.impls.GliderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/glider")
@Controller
public class GliderUIController {

    @Autowired
    GliderServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Glider> gliderList = service.getAll();
        model.addAttribute("gliderList", gliderList);

        return "glider/gliderList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Glider glider = service.getById(id);
        model.addAttribute("glider",glider);
        return "glider/updateGlider";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Glider glider = new Glider();
        model.addAttribute("glider", glider);
        return "glider/newGlider";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Glider glider) {
        model.addAttribute("glider", service.create(glider));
        return "redirect:/ui/glider/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Glider glider) {

        service.update(glider);
        return "redirect:/ui/glider/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/glider/get/all";
    }
}
