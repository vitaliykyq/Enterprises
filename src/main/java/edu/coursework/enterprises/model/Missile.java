package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Missiles 
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
@Document(collection = "missile")
public class Missile {
    @Id
    private String id;

    private String name;
    private String model;
    private String type;
    private int issue;
    private String classOfMissile;
    private String missileStuffing;
    private int chargePower;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Missile(String id, String name, String model,
                   String type, int issue, String classOfMissile, String missileStuffing, int chargePower) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.type = type;
        this.issue = issue;
        this.classOfMissile = classOfMissile;
        this.missileStuffing = missileStuffing;
        this.chargePower = chargePower;
        this.created_at = new Date();
    }
}
