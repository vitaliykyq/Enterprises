package edu.coursework.enterprises.service.shop.interfaces;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    ICivilService 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import edu.coursework.enterprises.model.Shop;

import java.util.List;

public interface IShopService {

    Shop getById(String id);
    Shop create(Shop shop);
    Shop update(Shop shop);
    Shop delete(String id);
    List<Shop> getAll();
}
