package edu.coursework.enterprises.service.testing.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Testing;
import edu.coursework.enterprises.repository.TestingRepository;
import edu.coursework.enterprises.service.testing.interfaces.ITestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TestingServiceImpl implements ITestingService {

    @Autowired
    TestingRepository repository;

    @Override
    public Testing getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Testing create(Testing testing) {
        testing.setCreatedAt(new Date());
        return repository.save(testing);
    }

    @Override
    public Testing update(Testing testing) {
        testing.setModifiedAt(new Date());
        testing.setCreatedAt(repository.findById(testing.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(testing);
        return testing;
    }

    @Override
    public Testing delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Testing> getAll() {

        return repository.findAll();
    }
}
