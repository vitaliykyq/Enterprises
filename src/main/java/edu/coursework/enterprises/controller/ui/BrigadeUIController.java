package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;
import edu.coursework.enterprises.service.brigade.impls.BrigadeServiceImpl;
import edu.coursework.enterprises.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/brigade")
@Controller
public class BrigadeUIController {

    @Autowired
    BrigadeServiceImpl brigadeService;

    @Autowired
    WorkerServiceImpl workerService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Brigade> brigadeList = brigadeService.getAll();
        model.addAttribute("brigadeList", brigadeList);

        return "brigade/brigadeList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Brigade brigade = brigadeService.getById(id);
        model.addAttribute("brigade",brigade);
        return "brigade/updateBrigade";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Brigade brigade = new Brigade();
        model.addAttribute("brigade", brigade);
        return "brigade/newBrigade";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Brigade brigade) {
        brigade.setBrigadier(workerService.getById(brigade.getBrigadier().getId()));
        /*brigade.setWorkerList(workerService.getById(brigade.getWorkerList().g()));*/
        model.addAttribute("brigade", brigadeService.create(brigade));
        return "redirect:/ui/brigade/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Brigade brigade) {

        brigadeService.update(brigade);
        return "redirect:/ui/brigade/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        brigadeService.delete(id);
        return "redirect:/ui/brigade/get/all";
    }
}
