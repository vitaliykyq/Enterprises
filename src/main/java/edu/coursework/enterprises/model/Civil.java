package edu.coursework.enterprises.model;

/*
    @author:    Bogdan
    @project:    Enterprises 
    @class:    Civil 
    @version:    1.0.0 
    @since:    15.04.2021     
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "civil")
public class Civil {
    @Id
    private String id;

    private Boolean isBusiness;
    private int seats;
    private Boolean isBaggage;

    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date modified_at;
    private String description;

    public Civil(String id, Boolean isBusiness, int seats, Boolean isBaggage) {
        this.id = id;
        this.isBusiness = isBusiness;
        this.seats = seats;
        this.isBaggage = isBaggage;
        this.created_at = new Date();
    }

    public Boolean getBusiness() {
        return isBusiness;
    }

    public void setBusiness(Boolean business) {
        isBusiness = business;
    }

    public Boolean getBaggage() {
        return isBaggage;
    }

    public void setBaggage(Boolean baggage) {
        isBaggage = baggage;
    }
}
