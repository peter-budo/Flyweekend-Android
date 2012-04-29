package com.flyweekend.android.model.flight;

import java.util.List;

public class ReturnFlexibleFlight extends Flight {

    private String startTime;
    private String endTime;
    private List<Integer> startDays;
    private List<Integer> returnDays;
    private List<Integer> months;
    private Integer weeks;

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

    public List<Integer> getStartDays() {
        return startDays;
    }

    public void setStartDays(List<Integer> startDays) {
        this.startDays = startDays;
    }

    public List<Integer> getReturnDays() {
        return returnDays;
    }

    public void setReturnDays(List<Integer> returnDays) {
        this.returnDays = returnDays;
    }

    public List<Integer> getMonths() {
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public Integer getWeeks() {
        return weeks;
    }

    public void setWeeks(Integer weeks) {
        this.weeks = weeks;
    }

    @Override
    public String toURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
