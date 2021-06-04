package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.*;
import edu.coursework.enterprises.service.civil.impls.CivilServiceImpl;
import edu.coursework.enterprises.service.glider.impls.GliderServiceImpl;
import edu.coursework.enterprises.service.hangGlider.impls.HangGliderServiceImpl;
import edu.coursework.enterprises.service.helicopter.impls.HelicopterServiceImpl;
import edu.coursework.enterprises.service.military.impls.MilitaryServiceImpl;
import edu.coursework.enterprises.service.missile.impls.MissileServiceImpl;
import edu.coursework.enterprises.service.plane.impls.PlaneServiceImpl;
import edu.coursework.enterprises.service.product.impls.ProductServiceImpl;
import edu.coursework.enterprises.service.transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/product")
@Controller
public class ProductUIController {

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    PlaneServiceImpl planeService;

    @Autowired
    GliderServiceImpl gliderService;

    @Autowired
    HangGliderServiceImpl hangGliderService;

    @Autowired
    HelicopterServiceImpl helicopterService;

    @Autowired
    MissileServiceImpl missileService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Product> productList = productService.getAll();
        model.addAttribute("productList", productList);

        return "product/productList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Product product = productService.getById(id);
        model.addAttribute("product",product);

        List<Plane> planeListId = planeService.getAll();
        model.addAttribute("planeListId", planeListId);

        List<Glider> gliderListId = gliderService.getAll();
        model.addAttribute("gliderListId", gliderListId);

        List<HangGlider> hangGliderListId = hangGliderService.getAll();
        model.addAttribute("hangGliderListId", hangGliderListId);

        List<Helicopter> helicopterListId = helicopterService.getAll();
        model.addAttribute("helicopterListId", helicopterListId);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);
        return "product/updateProduct";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        List<Plane> planeListId = planeService.getAll();
        model.addAttribute("planeListId", planeListId);

        List<Glider> gliderListId = gliderService.getAll();
        model.addAttribute("gliderListId", gliderListId);

        List<HangGlider> hangGliderListId = hangGliderService.getAll();
        model.addAttribute("hangGliderListId", hangGliderListId);

        List<Helicopter> helicopterListId = helicopterService.getAll();
        model.addAttribute("helicopterListId", helicopterListId);

        List<Missile> missileListId = missileService.getAll();
        model.addAttribute("missileListId", missileListId);
        return "product/newProduct";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Product product) {
        product.setPlane(planeService.getById(product.getPlane().getId()));
        product.setGlider(gliderService.getById(product.getGlider().getId()));
        product.setHangGlider(hangGliderService.getById(product.getHangGlider().getId()));
        product.setHelicopter(helicopterService.getById(product.getHelicopter().getId()));
        product.setMissile(missileService.getById(product.getMissile().getId()));

        model.addAttribute("product", productService.create(product));
        return "redirect:/ui/product/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Product product) {

        productService.update(product);
        return "redirect:/ui/product/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        productService.delete(id);
        return "redirect:/ui/product/get/all";
    }
}
