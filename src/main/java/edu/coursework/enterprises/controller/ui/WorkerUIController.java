package edu.coursework.enterprises.controller.ui;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilUIController 
    @version:    1.0.0 
    @since:    26.04.2021     
*/

import edu.coursework.enterprises.model.Worker;
import edu.coursework.enterprises.service.person.impls.PersonServiceImpl;
import edu.coursework.enterprises.service.worker.impls.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/ui/worker")
@Controller
public class WorkerUIController {

    @Autowired
    WorkerServiceImpl workerService;

    @Autowired
    PersonServiceImpl personService;

    @RequestMapping("/get/all")
    public String showAll(Model model){

        List<Worker> workerList = workerService.getAll();
        model.addAttribute("workerList", workerList);

        return "worker/workerList";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value="id") String id, Model model){
        Worker worker = workerService.getById(id);
        model.addAttribute("worker",worker);
        return "worker/updateWorker";
    }

    @GetMapping("/showNewForm")
    public String showNewForm(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);
        return "worker/newWorker";
    }

    @PostMapping("/add")
    public String add(Model model, @ModelAttribute("employee") @RequestBody Worker worker) {
        worker.setPerson(personService.getById(worker.getPerson().getId()));
        model.addAttribute("worker", workerService.create(worker));
        return "redirect:/ui/worker/get/all";
    }

    @PostMapping("/update")
    public String update(Model model, @ModelAttribute("employee") @RequestBody Worker worker) {

        workerService.update(worker);
        return "redirect:/ui/worker/get/all";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable String id){
        workerService.delete(id);
        return "redirect:/ui/worker/get/all";
    }
}
