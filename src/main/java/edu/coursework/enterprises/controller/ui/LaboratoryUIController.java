package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Laboratory;
import edu.coursework.enterprises.model.Testing;
import edu.coursework.enterprises.service.laboratory.impls.LaboratoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/laboratory")
@Controller
public class LaboratoryUIController {

    @Autowired
    LaboratoryServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Laboratory> laboratoryList = service.getAll();
        model.addAttribute("laboratoryList", laboratoryList);

        return "laboratory/laboratoryList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Laboratory laboratory = service.getById(id);
        model.addAttribute("laboratory",laboratory);
        return "laboratory/updateLaboratory";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Laboratory laboratory = new Laboratory();
        model.addAttribute("laboratory", laboratory);
        return "laboratory/newLaboratory";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Laboratory laboratory) {
        model.addAttribute("laboratory", service.create(laboratory));
        return "redirect:/ui/laboratory/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Laboratory laboratory) {

        service.update(laboratory);
        return "redirect:/ui/laboratory/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/laboratory/get/all";
    }
}
