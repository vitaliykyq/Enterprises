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

    private Date createdAt;
    private Date modifiedAt;
    private String description;
}
