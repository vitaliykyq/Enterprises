package edu.coursework.enterprises.service.helicopter.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Helicopter;
import edu.coursework.enterprises.repository.HelicopterRepository;
import edu.coursework.enterprises.service.helicopter.interfaces.IHelicopterService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Fields.fields;

@Service
@RequiredArgsConstructor
public class HelicopterServiceImpl implements IHelicopterService {

    @Autowired
    HelicopterRepository repository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Helicopter getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Helicopter create(Helicopter helicopter) {
        helicopter.setCreatedAt(new Date());
        return repository.save(helicopter);
    }

    @Override
    public Helicopter update(Helicopter helicopter) {
        helicopter.setModifiedAt(new Date());
        helicopter.setCreatedAt(repository.findById(helicopter.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(helicopter);
        return helicopter;
    }

    @Override
    public Helicopter delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Helicopter> getAll() {

        return repository.findAll();
    }


    public Object getAllByName(String name) {
        return  repository.getAllByName(name);
    }

    public Object getAllByModel(String name) {
        return  repository.getAllByModel(name);
    }

    public Object getAmountOfHelicoptersOfModel(String model) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("model").is(model)),
                Aggregation.group(fields().and("model")).count().as("amount"));

        return mongoTemplate.aggregate(aggregation, "helicopter", Object.class).getMappedResults();
    }

    public Object getAmountOfHelicoptersOfEveryModel() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group(fields().and("model")).count().as("amount"));

        return mongoTemplate.aggregate(aggregation, "helicopter", Object.class).getMappedResults();
    }




}
