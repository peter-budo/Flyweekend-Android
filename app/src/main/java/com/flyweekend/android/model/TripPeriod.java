package com.flyweekend.android.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class TripPeriod implements Serializable {
    private final Date departureDate;
    private final Date returnDate;

    public TripPeriod(Date departureDate, Date returnDate) {
        this.departureDate = new Date(departureDate.getTime());
        this.returnDate = new Date(returnDate.getTime());
    }

    public Date getDepartureDate() {
        return new Date(departureDate.getTime());
    }

    public Date getReturnDate() {
        return new Date(returnDate.getTime());
    }

    public TripPeriod departOnBeforeOrAfter(int numOfDays) {
        return new TripPeriod(adjustDateBy(getDepartureDate(), numOfDays), getReturnDate());
    }

    public TripPeriod returnOnBeforeOrAfter(int numOfDays) {
        return new TripPeriod(getDepartureDate(), adjustDateBy(getReturnDate(), numOfDays));
    }

    private Date adjustDateBy(Date currentDate, int numOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, numOfDays);

        return calendar.getTime();

    }


    public TripPeriod withIn(int departureAdjustment, int returnAdjustment) {
        return new TripPeriod(adjustDateBy(getDepartureDate(), departureAdjustment), adjustDateBy(getReturnDate(), returnAdjustment));

    }

    @Override
    public String toString() {
        return "TripPeriod{" +
                "departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TripPeriod that = (TripPeriod) o;

        if (!departureDate.equals(that.departureDate)) return false;
        if (!returnDate.equals(that.returnDate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departureDate != null ? departureDate.hashCode() : 0;
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        return result;
    }
}
