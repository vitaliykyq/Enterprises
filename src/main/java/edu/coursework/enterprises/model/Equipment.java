package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Equipment 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Equipment {

    private String id;

    private String name;
    private double price;
    private double weight;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Equipment(String id, String name, double price, double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.created_at = LocalDateTime.now();
    }
}
