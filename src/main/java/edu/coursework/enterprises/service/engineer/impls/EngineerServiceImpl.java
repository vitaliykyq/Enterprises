package edu.coursework.enterprises.service.engineer.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Engineer;
import edu.coursework.enterprises.repository.EngineerRepository;
import edu.coursework.enterprises.service.engineer.interfaces.IEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EngineerServiceImpl implements IEngineerService {

    @Autowired
    EngineerRepository repository;

    @Override
    public Engineer getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Engineer create(Engineer engineer) {
        engineer.setCreatedAt(new Date());
        return repository.save(engineer);
    }

    @Override
    public Engineer update(Engineer engineer) {
        engineer.setModifiedAt(new Date());
        engineer.setCreatedAt(repository.findById(engineer.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(engineer);
        return engineer;
    }

    @Override
    public Engineer delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Engineer> getAll() {

        return repository.findAll();
    }
}
