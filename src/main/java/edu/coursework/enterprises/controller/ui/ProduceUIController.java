package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ProduceUIController
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;
import edu.coursework.enterprises.model.Engineer;
import edu.coursework.enterprises.model.Produce;
import edu.coursework.enterprises.model.Product;
import edu.coursework.enterprises.service.produce.impls.ProduceServiceImpl;
import edu.coursework.enterprises.service.product.impls.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/produce")
@Controller
public class ProduceUIController {

    @Autowired
    ProduceServiceImpl produceService;

    @Autowired
    ProductServiceImpl productService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Produce> produceList = produceService.getAll();
        model.addAttribute("produceList", produceList);

        return "produce/produceList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Produce produce = produceService.getById(id);
        model.addAttribute("produce",produce);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);
        return "produce/updateProduce";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Produce produce = new Produce();
        model.addAttribute("produce", produce);

        List<Product> productListId = productService.getAll();
        model.addAttribute("productListId", productListId);
        return "produce/newProduce";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("produce") @RequestBody Produce produce) {
        produce.setProduct(productService.getById(produce.getProduct().getId()));
        model.addAttribute("produce", produceService.create(produce));
        return "redirect:/ui/produce/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("produce") @RequestBody Produce produce) {

        produceService.update(produce);
        return "redirect:/ui/produce/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        produceService.delete(id);
        return "redirect:/ui/produce/get/all";
    }
}
