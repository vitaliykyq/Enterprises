package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Engineer;
import edu.coursework.enterprises.model.Person;
import edu.coursework.enterprises.service.engineer.impls.EngineerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/engineer")
@Controller
public class EngineerUIController {

    @Autowired
    EngineerServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Engineer> engineerList = service.getAll();
        model.addAttribute("engineerList", engineerList);

        return "engineer/engineerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Engineer engineer = service.getById(id);
        model.addAttribute("engineer",engineer);
        return "engineer/updateEngineer";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Engineer engineer = new Engineer();
        model.addAttribute("engineer", engineer);
        return "engineer/newEngineer";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Engineer engineer) {
        model.addAttribute("engineer", service.create(engineer));
        return "redirect:/ui/engineer/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Engineer engineer) {

        service.update(engineer);
        return "redirect:/ui/engineer/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/engineer/get/all";
    }
}
