package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Helicopter 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Helicopter {

    private String id;

    private String name;
    private String model;
    private Object type;
    private int issue;
    private int aircrew;
    private double height;
    private double length;
    private double ceiling;
    private String engineType;
    private String rating;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Helicopter(String id, String name, String model, Object type, int issue,
                      int aircrew, double height, double length, double ceiling, String engineType, String rating) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.type = type;
        this.issue = issue;
        this.aircrew = aircrew;
        this.height = height;
        this.length = length;
        this.ceiling = ceiling;
        this.engineType = engineType;
        this.rating = rating;
        this.created_at = LocalDateTime.now();
    }
}
