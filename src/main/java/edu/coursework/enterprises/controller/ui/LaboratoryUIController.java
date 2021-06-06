package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    LaboratoryUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Laboratory;
import edu.coursework.enterprises.model.Person;
import edu.coursework.enterprises.model.Testing;
import edu.coursework.enterprises.service.laboratory.impls.LaboratoryServiceImpl;
import edu.coursework.enterprises.service.testing.impls.TestingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/laboratory")
@Controller
public class LaboratoryUIController {

    @Autowired
    LaboratoryServiceImpl laboratoryService;

    @Autowired
    TestingServiceImpl testingService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Laboratory> laboratoryList = laboratoryService.getAll();
        model.addAttribute("laboratoryList", laboratoryList);

        return "laboratory/laboratoryList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Laboratory laboratory = laboratoryService.getById(id);
        model.addAttribute("laboratory", laboratory);

        List<Testing> testingListId = testingService.getAll();
        model.addAttribute("testingListId", testingListId);
        return "laboratory/updateLaboratory";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Laboratory laboratory = new Laboratory();
        model.addAttribute("laboratory", laboratory);

        List<Testing> testingListId = testingService.getAll();
        model.addAttribute("testingListId", testingListId);
        return "laboratory/newLaboratory";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("laboratory") @RequestBody Laboratory laboratory) {
        model.addAttribute("laboratory", laboratoryService.create(laboratory));
        return "redirect:/ui/laboratory/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("laboratory") @RequestBody Laboratory laboratory) {

        laboratoryService.update(laboratory);
        return "redirect:/ui/laboratory/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        laboratoryService.delete(id);
        return "redirect:/ui/laboratory/get/all";
    }
}
