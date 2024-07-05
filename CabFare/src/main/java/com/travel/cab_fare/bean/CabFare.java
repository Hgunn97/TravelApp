package com.travel.cab_fare.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cab_fare")
public class CabFare {
    @Id
    private int id;
    private String fromLocation;
    private String toLocation;
    private String typeOfCab;
    private float amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getTypeOfCab() {
        return typeOfCab;
    }

    public void setTypeOfCab(String typeOfCab) {
        this.typeOfCab = typeOfCab;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
