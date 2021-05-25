package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/civil")
@Controller
public class CivilUIController {

    @Autowired
    CivilServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Civil> civilList = service.getAll();
        model.addAttribute("civilList", civilList);

        return "civil/civilList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Civil civil = service.getById(id);
        model.addAttribute("civil", civil);
        return "civil/updateCivil";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Civil civil = new Civil();
        model.addAttribute("civil", civil);
        return "civil/newCivil";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("civil") @RequestBody Civil civil) {
        model.addAttribute("civil", service.create(civil));
        return "redirect:/ui/civil/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("civil") @RequestBody Civil civil) {

        service.update(civil);
        return "redirect:/ui/civil/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/civil/get/all";
    }
}
