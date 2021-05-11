package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Brigade 
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

public class Brigade {

    private String id;

    private Worker brigadier;
    private List<Worker> workers;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Brigade(String id, Worker brigadier, List<Worker> workers) {
        this.id = id;
        this.brigadier = brigadier;
        this.workers = workers;
        this.created_at = LocalDateTime.now();
    }
}
