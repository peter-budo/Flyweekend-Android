package com.flyweekend.android.model.flight;

import java.util.Date;

public class ReturnFixedFlight extends Flight{

    private Date startDate;
    private Date endDate;
    private String startTime;
    private String endTime;

    public ReturnFixedFlight(double budget, String destination, String departure, Date startDate, Date endDate
            , String startTime, String endTime, int adults, int children, int infants, String category){
        setBudget(budget);
        setDestination(destination);
        setDeparture(departure);
        setStartDate(startDate);
        setEndDate(endDate);
        setStartTime(startTime);
        setEndTime(endTime);
        setAdults(adults);
        setChildren(children);
        setInfants(infants);
        setCategory(category);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = new Date(startDate.getTime());
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = new Date(endDate.getTime());
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toURL() {
        return null;
    }
}
