package com.flyweekend.android.model.flight;

import java.util.List;

public class OneWayFlexibleFlight extends Flight {

    private String startTime;
    private List<Integer> startDays;
    private List<Integer> months;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getStartDays() {
        return startDays;
    }

    public void setStartDays(List<Integer> startDays) {
        this.startDays = startDays;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    @Override
    public String toURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
