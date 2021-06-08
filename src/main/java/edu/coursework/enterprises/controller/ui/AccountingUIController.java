package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    AccountingUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.*;
import edu.coursework.enterprises.service.accounting.impls.AccountingServiceImpl;
import edu.coursework.enterprises.service.glider.impls.GliderServiceImpl;
import edu.coursework.enterprises.service.hangGlider.impls.HangGliderServiceImpl;
import edu.coursework.enterprises.service.laboratory.impls.LaboratoryServiceImpl;
import edu.coursework.enterprises.service.missile.impls.MissileServiceImpl;
import edu.coursework.enterprises.service.product.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/accounting")
@Controller
public class AccountingUIController {

    @Autowired
    AccountingServiceImpl accountingService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    GliderServiceImpl gliderService;

    @Autowired
    HangGliderServiceImpl hangGliderService;

    @Autowired
    MissileServiceImpl missileService;

    @Autowired
    LaboratoryServiceImpl laboratoryService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Accounting> accountingList = accountingService.getAll();
        model.addAttribute("accountingList", accountingList);

        return "accounting/accountingList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Accounting accounting = accountingService.getById(id);
        model.addAttribute("accounting", accounting);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);

        List<Glider> gliderListId = gliderService.getAll();
        model.addAttribute("gliderListId", gliderListId);

        List<HangGlider> hangGliderListId = hangGliderService.getAll();
        model.addAttribute("hangGliderListId", hangGliderListId);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);

        List<Laboratory> laboratoryListId = laboratoryService.getAll();
        model.addAttribute("laboratoryListId", laboratoryListId);
        return "accounting/updateAccounting";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Accounting accounting = new Accounting();
        model.addAttribute("accounting", accounting);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);

        List<Glider> gliderListId = gliderService.getAll();
        model.addAttribute("gliderListId", gliderListId);

        List<HangGlider> hangGliderListId = hangGliderService.getAll();
        model.addAttribute("hangGliderListId", hangGliderListId);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);

        List<Laboratory> laboratoryListId = laboratoryService.getAll();
        model.addAttribute("laboratoryListId", laboratoryListId);
        return "accounting/newAccounting";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("accounting") @RequestBody Accounting accounting) {
        model.addAttribute("accounting", accountingService.create(accounting));
        return "redirect:/ui/accounting/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("accounting") @RequestBody Accounting accounting) {

        accountingService.update(accounting);
        return "redirect:/ui/accounting/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        accountingService.delete(id);
        return "redirect:/ui/accounting/get/all";
    }
}
