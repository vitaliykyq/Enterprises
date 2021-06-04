package edu.coursework.enterprises.service.produce.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Produce;
import edu.coursework.enterprises.repository.ProduceRepository;
import edu.coursework.enterprises.service.produce.interfaces.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProduceServiceImpl implements IProduceService {

    @Autowired
    ProduceRepository repository;

    @Override
    public Produce getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Produce create(Produce produce) {
        produce.setCreatedAt(new Date());
        return repository.save(produce);
    }

    @Override
    public Produce update(Produce produce) {
        produce.setModifiedAt(new Date());
        produce.setCreatedAt(repository.findById(produce.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(produce);
        return produce;
    }

    @Override
    public Produce delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Produce> getAll() {

        return repository.findAll();
    }
}
