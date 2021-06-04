package edu.coursework.enterprises.service.plot.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Plot;
import edu.coursework.enterprises.repository.PlotRepository;
import edu.coursework.enterprises.service.plot.interfaces.IPlotService;
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
public class PlotServiceImpl implements IPlotService {

    @Autowired
    PlotRepository repository;

    private final MongoTemplate mongoTemplate;

    @Override
    public Plot getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Plot create(Plot plot) {
        plot.setCreatedAt(new Date());
        return repository.save(plot);
    }

    @Override
    public Plot update(Plot plot) {
        plot.setModifiedAt(new Date());
        plot.setCreatedAt(repository.findById(plot.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(plot);
        return plot;
    }

    @Override
    public Plot delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Plot> getAll() {

        return repository.findAll();
    }
    public Object getProductFromPlot(int number) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("number").is(number)),
                Aggregation.project("produceList"));

        return mongoTemplate.aggregate(aggregation, "plot", Object.class).getMappedResults();
    }
}
