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
import edu.coursework.enterprises.service.engineer.impls.EngineerServiceImpl;
import edu.coursework.enterprises.service.equipment.impls.EquipmentServiceImpl;
import edu.coursework.enterprises.service.product.impls.ProductServiceImpl;
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
    TestingServiceImpl testingService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    EngineerServiceImpl engineerService;

    @Autowired
    EquipmentServiceImpl equipmentService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Testing> testingList = testingService.getAll();
        model.addAttribute("testingList", testingList);

        return "testing/testingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Testing testing = testingService.getById(id);
        model.addAttribute("testing",testing);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);

        List<Engineer> engineerListId = engineerService.getAll();
        model.addAttribute("engineerListId", engineerListId);

        List<Equipment> equipmentListId = equipmentService.getAll();
        model.addAttribute("equipmentListId", equipmentListId);
        return "testing/updateTesting";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Testing testing = new Testing();
        model.addAttribute("testing", testing);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);

        List<Engineer> engineerListId = engineerService.getAll();
        model.addAttribute("engineerListId", engineerListId);

        List<Equipment> equipmentListId = equipmentService.getAll();
        model.addAttribute("equipmentListId", equipmentListId);
        return "testing/newTesting";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("testing") @RequestBody Testing testing) {
        model.addAttribute("testing", testingService.create(testing));
        return "redirect:/ui/testing/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("testing") @RequestBody Testing testing) {

        testingService.update(testing);
        return "redirect:/ui/testing/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        testingService.delete(id);
        return "redirect:/ui/testing/get/all";
    }
}
