package edu.coursework.enterprises.service.product.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Product;

import java.util.List;

public interface IProductService {

    Product getById(String id);
    Product create(Product product);
    Product update(Product product);
    Product delete(String id);
    List<Product> getAll();
}
