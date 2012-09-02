package com.flyweekend.android.builders;

import com.flyweekend.android.model.flight.ReturnFixedFlight;

import java.util.Date;

public class ReturnFixedFlightBuilder extends AbstractBuilder<ReturnFixedFlightBuilder, ReturnFixedFlight> {

    private double budget;
    private String destination;
    private String departure;
    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;
    private int adults;
    private int children;
    private int infants;
    private String category;

    public static ReturnFixedFlightBuilder aReturnFixedFlight() {
        return new ReturnFixedFlightBuilder();
    }

    public ReturnFixedFlight build() {
        return new ReturnFixedFlight(budget, destination, departure, startDate, endDate, startTime, endTime
                , adults, children, infants, category);
    }



    public ReturnFixedFlightBuilder withBudget(double budget){
        ReturnFixedFlightBuilder other = this.clone();
        other.budget = budget;
        return other;
    }

    public ReturnFixedFlightBuilder withDestination(String destination){
        ReturnFixedFlightBuilder other = this.clone();
        other.destination = destination;
        return other;
    }

    public ReturnFixedFlightBuilder withDeparture(String departure){
        ReturnFixedFlightBuilder other = this.clone();
        other.departure = departure;
        return other;
    }

    public ReturnFixedFlightBuilder withStartDate(Date startDate){
        ReturnFixedFlightBuilder other = this.clone();
        other.startDate = new Date(startDate.getTime());
        return other;
    }

    public ReturnFixedFlightBuilder withEndDate(Date endDate){
        ReturnFixedFlightBuilder other = this.clone();
        other.endDate = new Date(endDate.getTime());
        return other;
    }

    public ReturnFixedFlightBuilder withStartTime(String startTime){
        ReturnFixedFlightBuilder other = this.clone();
        other.startTime = startTime;
        return other;
    }

    public ReturnFixedFlightBuilder withEndTime(String endTime){
        ReturnFixedFlightBuilder other = this.clone();
        other.endTime = endTime;
        return other;
    }

    public ReturnFixedFlightBuilder withAdults(int adults){
        ReturnFixedFlightBuilder other = this.clone();
        other.adults = adults;
        return other;
    }

    public ReturnFixedFlightBuilder withChildren(int children){
        ReturnFixedFlightBuilder other = this.clone();
        other.children = children;
        return other;
    }

    public ReturnFixedFlightBuilder withInfants(int infants){
        ReturnFixedFlightBuilder other = this.clone();
        other.infants = infants;
        return other;
    }

    public ReturnFixedFlightBuilder withCategory(String category){
        ReturnFixedFlightBuilder other = this.clone();
        other.category = category;
        return other;
    }
}
