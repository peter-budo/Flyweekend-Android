package com.flyweekend.android.model.hotel;

import java.util.Date;

public class FixedHotel extends Hotel {

    private Date startDate;
    private Date endDate;

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

    @Override
    public String toURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
