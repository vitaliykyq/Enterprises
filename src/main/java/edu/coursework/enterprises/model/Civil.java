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

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Civil {

    private String id;

    private Boolean isBusiness;
    private int seats;
    private Boolean isBaggage;

    private LocalDateTime created_at;
    private LocalDateTime modified_at;
    private String description;

    public Civil(String id, Boolean isBusiness, int seats, Boolean isBaggage) {
        this.id = id;
        this.isBusiness = isBusiness;
        this.seats = seats;
        this.isBaggage = isBaggage;
        created_at = LocalDateTime.now();
    }

    public String myBool(boolean isBool){

        return isBool ? "true" : "false";
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
