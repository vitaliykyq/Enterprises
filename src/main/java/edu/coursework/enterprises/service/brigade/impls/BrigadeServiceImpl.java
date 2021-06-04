package edu.coursework.enterprises.service.brigade.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Brigade;
import edu.coursework.enterprises.model.Civil;
import edu.coursework.enterprises.repository.BrigadeRepository;
import edu.coursework.enterprises.service.brigade.interfaces.IBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BrigadeServiceImpl implements IBrigadeService {

    @Autowired
    BrigadeRepository repository;

    @Override
    public Brigade getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Brigade create(Brigade brigade) {
        brigade.setCreatedAt(new Date());
        return repository.save(brigade);
    }

    @Override
    public Brigade update(Brigade brigade) {
        brigade.setModifiedAt(new Date());
        brigade.setCreatedAt(repository.findById(brigade.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(brigade);
        return brigade;
    }

    @Override
    public Brigade delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Brigade> getAll() {

        return repository.findAll();
    }
}
