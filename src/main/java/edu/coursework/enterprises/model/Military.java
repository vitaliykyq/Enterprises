package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Military 
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

public class Military {

    private String id;

    private int ammunition;
    private String armor;
    private List<Missile> missiles;
    private int speed;
    private String type;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;


}
