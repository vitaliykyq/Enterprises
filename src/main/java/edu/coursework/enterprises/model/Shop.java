package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Shop 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Shop {

    private String id;

    private List<Plot> plots;
    private Engineer head;
    private List<Laboratory> laboratories;
    private double area;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Shop(String id, List<Plot> plots, Engineer head, List<Laboratory> laboratories, double area) {
        this.id = id;
        this.plots = plots;
        this.head = head;
        this.laboratories = laboratories;
        this.area = area;
        this.created_at =LocalDateTime.now();
    }
}
