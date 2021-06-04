package edu.coursework.enterprises.service.transport.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Transport;
import edu.coursework.enterprises.repository.TransportRepository;
import edu.coursework.enterprises.service.transport.interfaces.ITransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransportServiceImpl implements ITransportService {

    @Autowired
    TransportRepository repository;

    @Override
    public Transport getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Transport create(Transport transport) {
        transport.setCreatedAt(new Date());
        return repository.save(transport);
    }

    @Override
    public Transport update(Transport transport) {
        transport.setModifiedAt(new Date());
        transport.setCreatedAt(repository.findById(transport.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(transport);
        return transport;
    }

    @Override
    public Transport delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Transport> getAll() {

        return repository.findAll();
    }
}
