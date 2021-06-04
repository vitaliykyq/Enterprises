package edu.coursework.enterprises.service.worker.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Worker;
import edu.coursework.enterprises.repository.WorkerRepository;
import edu.coursework.enterprises.service.worker.interfaces.IWorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    WorkerRepository repository;

    @Override
    public Worker getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Worker create(Worker worker) {
        worker.setCreatedAt(new Date());
        return repository.save(worker);
    }

    @Override
    public Worker update(Worker worker) {
        worker.setModifiedAt(new Date());
        worker.setCreatedAt(repository.findById(worker.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(worker);
        return worker;
    }

    @Override
    public Worker delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Worker> getAll() {

        return repository.findAll();
    }
}
