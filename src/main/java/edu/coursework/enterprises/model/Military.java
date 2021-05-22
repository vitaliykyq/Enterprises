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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "military")
public class Military {
    @Id
    private String id;

    private int ammunition;
    private String armor;
    private List<Missile> missileList;
    private int speed;
    private String type;

    private Date created_at;
    private Date modified_at;
    private String description;

    public Military(String id, int ammunition, String armor, List<Missile> missileList, int speed, String type) {
        this.id = id;
        this.ammunition = ammunition;
        this.armor = armor;
        this.missileList = missileList;
        this.speed = speed;
        this.type = type;
        this.created_at = new Date();
    }
}
