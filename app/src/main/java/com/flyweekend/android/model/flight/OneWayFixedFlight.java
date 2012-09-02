package com.flyweekend.android.model.flight;

import java.util.Date;

public class OneWayFixedFlight extends Flight {

    private Date startDate;
    private String startTime;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = new Date(startDate.getTime());
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
