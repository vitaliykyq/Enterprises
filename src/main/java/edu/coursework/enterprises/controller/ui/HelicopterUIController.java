package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.model.Helicopter;
import edu.coursework.enterprises.model.Military;
import edu.coursework.enterprises.model.Transport;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import edu.coursework.enterprises.service.helicopter.impls.HelicopterServiceImpl;
import edu.coursework.enterprises.service.military.impls.MilitaryServiceImpl;
import edu.coursework.enterprises.service.transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/helicopter")
@Controller
public class HelicopterUIController {

    @Autowired
    HelicopterServiceImpl helicopterService;

    @Autowired
    CivilServiceImpl civilService;

    @Autowired
    MilitaryServiceImpl militaryService;

    @Autowired
    TransportServiceImpl transportService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Helicopter> helicopterList = helicopterService.getAll();
        model.addAttribute("helicopterList", helicopterList);

        return "helicopter/helicopterList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Helicopter helicopter = helicopterService.getById(id);
        model.addAttribute("helicopter",helicopter);

        List<Civil> civilListId = civilService.getAll();
        model.addAttribute("civilListId", civilListId);

        List<Military> militaryListId = militaryService.getAll();
        model.addAttribute("militaryListId", militaryListId);

        List<Transport> transportListId = transportService.getAll();
        model.addAttribute("transportListId", transportListId);
        return "helicopter/updateHelicopter";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Helicopter helicopter = new Helicopter();
        model.addAttribute("helicopter", helicopter);

        List<Civil> civilListId = civilService.getAll();
        model.addAttribute("civilListId", civilListId);

        List<Military> militaryListId = militaryService.getAll();
        model.addAttribute("militaryListId", militaryListId);

        List<Transport> transportListId = transportService.getAll();
        model.addAttribute("transportListId", transportListId);
        return "helicopter/newHelicopter";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Helicopter helicopter) {
        helicopter.setCivil(civilService.getById(helicopter.getCivil().getId()));
        helicopter.setMilitary(militaryService.getById(helicopter.getMilitary().getId()));
        helicopter.setTransport(transportService.getById(helicopter.getTransport().getId()));

        model.addAttribute("helicopter", helicopterService.create(helicopter));
        return "redirect:/ui/helicopter/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Helicopter helicopter) {

        helicopterService.update(helicopter);
        return "redirect:/ui/helicopter/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        helicopterService.delete(id);
        return "redirect:/ui/helicopter/get/all";
    }
}
