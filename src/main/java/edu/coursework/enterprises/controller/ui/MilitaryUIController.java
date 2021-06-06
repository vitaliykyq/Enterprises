package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Military;
import edu.coursework.enterprises.model.Missile;
import edu.coursework.enterprises.service.military.impls.MilitaryServiceImpl;
import edu.coursework.enterprises.service.missile.impls.MissileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/military")
@Controller
public class MilitaryUIController {

    @Autowired
    MilitaryServiceImpl militaryService;

    @Autowired
    MissileServiceImpl missileService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Military> militaryList = militaryService.getAll();
        model.addAttribute("militaryList", militaryList);

        return "military/militaryList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Military military = militaryService.getById(id);
        model.addAttribute("military",military);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);
        return "military/updateMilitary";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Military military = new Military();
        model.addAttribute("military", military);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);
        return "military/newMilitary";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("military") @RequestBody Military military) {
        model.addAttribute("military", militaryService.create(military));
        return "redirect:/ui/military/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("military") @RequestBody Military military) {

        militaryService.update(military);
        return "redirect:/ui/military/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        militaryService.delete(id);
        return "redirect:/ui/military/get/all";
    }
}
