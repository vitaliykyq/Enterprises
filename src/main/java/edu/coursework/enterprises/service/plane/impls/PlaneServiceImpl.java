package edu.coursework.enterprises.service.plane.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plane;
import edu.coursework.enterprises.repository.PlaneRepository;
import edu.coursework.enterprises.service.plane.interfaces.IPlaneService;
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
public class PlaneServiceImpl implements IPlaneService {

    @Autowired
    PlaneRepository repository;
    private final MongoTemplate mongoTemplate;
    @Override
    public Plane getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Plane create(Plane plane) {
        plane.setCreatedAt(new Date());
        return repository.save(plane);
    }

    @Override
    public Plane update(Plane plane) {
        plane.setModifiedAt(new Date());
        plane.setCreatedAt(repository.findById(plane.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(plane);
        return plane;
    }

    @Override
    public Plane delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Plane> getAll() {

        return repository.findAll();
    }


    public Object getAllByModel(String model) {

        return repository.getAllByModel(model);
    }


    public Object getAllByName(String name) {

        return repository.getAllByName(name);
    }
    public Object getAmountOfPlanesOfModel(String model) {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("model").is(model)),
                Aggregation.group(fields().and("model")).count().as("amount"));

        return mongoTemplate.aggregate(aggregation, "plane", Object.class).getMappedResults();
    }

    public Object getAmountOfPlanesOfEveryModel() {

        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.group(fields().and("model")).count().as("amount"));

        return mongoTemplate.aggregate(aggregation, "plane", Object.class).getMappedResults();
    }
}
