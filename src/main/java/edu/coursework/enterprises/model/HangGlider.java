package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    HangGlider 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hangGlider")
public class HangGlider {
    @Id
    private String id;

    private String name;
    private String model;
    private int issue;
    private int aircrew;
    private double height;
    private double length;
    private double ceiling;
    private String engineType;
    private String rating;

    private Date created_at;
    private Date modified_at;
    private String description;

    public HangGlider(String id, String name, String model, int issue,
                      int aircrew, double height, double length, double ceiling, String engineType, String rating) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.issue = issue;
        this.aircrew = aircrew;
        this.height = height;
        this.length = length;
        this.ceiling = ceiling;
        this.engineType = engineType;
        this.rating = rating;
        this.created_at = new Date();
    }
}
