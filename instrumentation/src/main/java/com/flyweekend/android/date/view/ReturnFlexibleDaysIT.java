package com.flyweekend.android.date.view;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import com.flyweekend.android.FlyweekendActivity;
import com.flyweekend.android.R;

import static android.test.ViewAsserts.assertOnScreen;

public class ReturnFlexibleDaysIT extends ActivityInstrumentationTestCase2<FlyweekendActivity> {
    private FlyweekendActivity activity;
    private TextView arrivalDateLabel;
    private Spinner arrivalDay;
    private Spinner arrivalTimesSpinner;
    private TextView returnDateLabel;
    private Spinner returnDay;
    private Spinner returnTimesSpinner;

    public ReturnFlexibleDaysIT() {
        super("com.flyweekend.android", FlyweekendActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = this.getActivity();
        arrivalDateLabel = (TextView) activity.findViewById(R.id.arrival_date_label);
        arrivalDay = (Spinner) activity.findViewById(R.id.arrival_day_spinner);
        arrivalTimesSpinner = (Spinner) activity.findViewById(R.id.arrival_time_spinner);
        returnDateLabel = (TextView) activity.findViewById(R.id.return_date_label);
        returnDay = (Spinner) activity.findViewById(R.id.return_day_spinner);
        returnTimesSpinner = (Spinner) activity.findViewById(R.id.return_time_spinner);
    }

    @UiThreadTest
    public void testInitialLayoutView(){
        assertNotNull(activity);
        final View view = getView();
        assertOnScreen(view, arrivalDateLabel);
        assertOnScreen(view, arrivalDay);
        assertOnScreen(view, arrivalTimesSpinner);
        int height = view.getHeight();
        int width = view.getWidth();
        view.scrollTo(height, width);
        assertOnScreen(view, returnDateLabel);
        assertOnScreen(view, returnDay);
        assertOnScreen(view, returnTimesSpinner);
    }

    private View getView(){
        return activity.getWindow().getDecorView();
    }
}