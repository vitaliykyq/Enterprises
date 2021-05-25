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

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
