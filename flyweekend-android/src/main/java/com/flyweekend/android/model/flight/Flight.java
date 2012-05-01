package com.flyweekend.android.model.flight;

import com.flyweekend.android.model.Trip;

public abstract class Flight extends Trip {

    private String departure;
    private Integer infants;

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public Integer getInfants() {
        return infants;
    }

    public void setInfants(Integer infants) {
        this.infants = infants;
    }
}
