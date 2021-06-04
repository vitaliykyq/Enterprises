package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Engineer;
import edu.coursework.enterprises.model.Equipment;
import edu.coursework.enterprises.model.Product;
import edu.coursework.enterprises.model.Testing;
import edu.coursework.enterprises.service.testing.impls.TestingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/testing")
@Controller
public class TestingUIController {

    @Autowired
    TestingServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Testing> testingList = service.getAll();
        model.addAttribute("testingList", testingList);

        return "testing/testingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Testing testing = service.getById(id);
        model.addAttribute("testing",testing);
        return "testing/updateTesting";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Testing testing = new Testing();
        model.addAttribute("testing", testing);
        return "testing/newTesting";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Testing testing) {
        model.addAttribute("testing", service.create(testing));
        return "redirect:/ui/testing/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Testing testing) {

        service.update(testing);
        return "redirect:/ui/testing/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/testing/get/all";
    }
}
