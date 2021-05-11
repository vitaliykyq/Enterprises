package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Plane 
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

public class Plane {

    private String id;

    private String name;
    private String model;
    private Civil civil;
    private int issue;
    private int aircrew;
    private int payload;
    private double height;
    private double length;
    private double wingspan;
    private double ceiling;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Plane(String id, String name, String model, Civil civil, int issue,
                 int aircrew, int payload, double height, double length, double wingspan, double ceiling) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.civil = civil;
        this.issue = issue;
        this.aircrew = aircrew;
        this.payload = payload;
        this.height = height;
        this.length = length;
        this.wingspan = wingspan;
        this.ceiling = ceiling;
        this.created_at = LocalDateTime.now();
    }
}
