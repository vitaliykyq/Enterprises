package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Transport;
import edu.coursework.enterprises.service.transport.impls.TransportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/transport")
@Controller
public class TransportUIController {

    @Autowired
    TransportServiceImpl service;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Transport> transportList = service.getAll();
        model.addAttribute("transportList", transportList);

        return "transport/transportList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Transport transport = service.getById(id);
        model.addAttribute("transport",transport);
        return "transport/updateTransport";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Transport transport = new Transport();
        model.addAttribute("transport", transport);
        return "transport/newTransport";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("transport") @RequestBody Transport transport) {
        model.addAttribute("transport", service.create(transport));
        return "redirect:/ui/transport/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("transport") @RequestBody Transport transport) {

        service.update(transport);
        return "redirect:/ui/transport/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        service.delete(id);
        return "redirect:/ui/transport/get/all";
    }
}
