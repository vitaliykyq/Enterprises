package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.HangGlider;
import edu.coursework.enterprises.service.hangGlider.impls.HangGliderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/hangGlider")
@Controller
public class HangGliderUIController {

    @Autowired
    HangGliderServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<HangGlider> hangGliderList = service.getAll();
        model.addAttribute("hangGliderList", hangGliderList);

        return "hangGlider/hangGliderList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        HangGlider hangGlider = service.getById(id);
        model.addAttribute("hangGlider",hangGlider);
        return "hangGlider/updateHangGlider";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        HangGlider hangGlider = new HangGlider();
        model.addAttribute("hangGlider", hangGlider);
        return "hangGlider/newHangGlider";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody HangGlider hangGlider) {
        model.addAttribute("hangGlider", service.create(hangGlider));
        return "redirect:/ui/hangGlider/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody HangGlider hangGlider) {

        service.update(hangGlider);
        return "redirect:/ui/hangGlider/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/hangGlider/get/all";
    }
}
