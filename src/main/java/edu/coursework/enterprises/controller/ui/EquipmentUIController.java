package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Equipment;
import edu.coursework.enterprises.service.equipment.impls.EquipmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/equipment")
@Controller
public class EquipmentUIController {

    @Autowired
    EquipmentServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Equipment> equipmentList = service.getAll();
        model.addAttribute("equipmentList", equipmentList);

        return "equipment/equipmentList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Equipment equipment = service.getById(id);
        model.addAttribute("equipment",equipment);
        return "equipment/updateEquipment";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Equipment equipment = new Equipment();
        model.addAttribute("equipment", equipment);
        return "equipment/newEquipment";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Equipment equipment) {
        model.addAttribute("equipment", service.create(equipment));
        return "redirect:/ui/equipment/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Equipment equipment) {

        service.update(equipment);
        return "redirect:/ui/equipment/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/equipment/get/all";
    }
}
