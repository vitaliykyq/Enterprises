package edu.coursework.enterprises.service.product.impls;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    CivilServiceImpl 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Product;
import edu.coursework.enterprises.repository.ProductRepository;
import edu.coursework.enterprises.service.product.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product getById(String id) {

        return repository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        product.setCreatedAt(new Date());
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        product.setModifiedAt(new Date());
        product.setCreatedAt(repository.findById(product.getId())
                .orElse(null)
                .getCreatedAt());
        repository.save(product);
        return product;
    }

    @Override
    public Product delete(String id) {
        repository.deleteById(id);
        return null;
    }

    @Override
    public List<Product> getAll() {

        return repository.findAll();
    }
}
