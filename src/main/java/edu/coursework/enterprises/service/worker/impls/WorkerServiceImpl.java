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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements IWorkerService {

    @Autowired
    WorkerRepository repository;
    private final MongoTemplate mongoTemplate;

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

    public Object getWorkersOfYear(int year) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.year").is(year)));

        return mongoTemplate.aggregate(aggregation, "worker", Object.class).getMappedResults();
    }

    public Object getNumWorkersOfYear(int year) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("person.year").is(year)),
                Aggregation.group().count().as("amountOfWorkersBornedThatYear"));

        return mongoTemplate.aggregate(aggregation, "worker", Object.class).getMappedResults();
    }
}
