package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Missile;
import edu.coursework.enterprises.service.missile.impls.MissileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/missile")
@Controller
public class MissileUIController {

    @Autowired
    MissileServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Missile> missileList = service.getAll();
        model.addAttribute("missileList", missileList);

        return "missile/missileList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Missile missile = service.getById(id);
        model.addAttribute("missile", missile);
        return "missile/updateMissile";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Missile missile = new Missile();
        model.addAttribute("missile", missile);
        return "missile/newMissile";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("missile") @RequestBody Missile missile) {
        model.addAttribute("missile", service.create(missile));
        return "redirect:/ui/missile/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("missile") @RequestBody Missile missile) {

        service.update(missile);
        return "redirect:/ui/missile/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/missile/get/all";
    }
}
