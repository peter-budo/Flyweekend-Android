package com.flyweekend.android.model.hotel;

import java.util.List;

public class FlexibleHotel extends Hotel {

    private List<Integer> startDays;
    private List<Integer> returnDays;
    private List<Integer> months;
    private Integer weeks;

    @Override
    public String toURL() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
