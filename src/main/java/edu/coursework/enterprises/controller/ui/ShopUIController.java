package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Shop;
import edu.coursework.enterprises.service.engineer.impls.EngineerServiceImpl;
import edu.coursework.enterprises.service.shop.impls.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/shop")
@Controller
public class ShopUIController {

    @Autowired
    ShopServiceImpl shopService;

    @Autowired
    EngineerServiceImpl engineerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Shop> shopList = shopService.getAll();
        model.addAttribute("shopList", shopList);

        return "shop/shopList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Shop shop = shopService.getById(id);
        model.addAttribute("shop",shop);
        return "shop/updateShop";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Shop shop = new Shop();
        model.addAttribute("shop", shop);
        return "shop/newShop";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Shop shop) {
        shop.setHead(engineerService.getById(shop.getHead().getId()));
        model.addAttribute("shop", shopService.create(shop));
        return "redirect:/ui/shop/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Shop shop) {

        shopService.update(shop);
        return "redirect:/ui/shop/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        shopService.delete(id);
        return "redirect:/ui/shop/get/all";
    }
}
