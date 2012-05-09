package com.flyweekend.android.fragments;

import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.*;
import com.flyweekend.android.FlyweekendActivity;
import com.flyweekend.android.R;

import static android.test.ViewAsserts.assertOnScreen;

public class FlightFragmentIT extends ActivityInstrumentationTestCase2<FlyweekendActivity> {

    private FragmentActivity activity;
    private EditText budget;
    private EditText arrivalLocation;
    private EditText departureLocation;
    private TextView flightLabel;
    private RadioGroup flightGroup;
    private RadioButton oneWayRadio;
    private RadioButton returnRadio;
    private TextView datesLabel;
    private RadioGroup datesGroup;
    private RadioButton flexibleDatesRadio;
    private RadioButton fixedDatesRadio;
    private RelativeLayout fixedDatesLayout;
    private RelativeLayout flexibleDatesLayout;
    private Button submit;

    public FlightFragmentIT(){
        super("com.flyweekend.android",FlyweekendActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = this.getActivity();
        budget = (EditText)activity.findViewById(R.id.budget);
        arrivalLocation = (EditText) activity.findViewById(R.id.arrivalLocation);
        departureLocation = (EditText) activity.findViewById(R.id.departureLocation);
        flightLabel = (TextView)activity.findViewById(R.id.flight_label);
        flightGroup = (RadioGroup) activity.findViewById(R.id.flight_radio_group);
        oneWayRadio = (RadioButton) activity.findViewById(R.id.one_way_flight);
        returnRadio = (RadioButton) activity.findViewById(R.id.return_flight);
        datesLabel = (TextView) activity.findViewById(R.id.date_label);
        datesGroup = (RadioGroup) activity.findViewById(R.id.dates_radio_group);
        flexibleDatesRadio = (RadioButton) activity.findViewById(R.id.flexible_dates);
        fixedDatesRadio = (RadioButton) activity.findViewById(R.id.fixed_dates);
        fixedDatesLayout = (RelativeLayout) activity.findViewById(R.id.fixed_dates_layout);
        flexibleDatesLayout = (RelativeLayout) activity.findViewById(R.id.flexible_dates_layout);
        submit = (Button) activity.findViewById(R.id.submit);
    }

    public void testInitialFragmentView(){
        assertNotNull(activity);
        final View view = getView();
        assertOnScreen(view, budget);
        assertOnScreen(view, arrivalLocation);
        assertOnScreen(view, departureLocation);
        assertOnScreen(view, flightLabel);
        assertOnScreen(view, flightGroup);
        assertOnScreen(view, oneWayRadio);
        assertOnScreen(view, returnRadio);
        assertOnScreen(view, datesLabel);
        assertOnScreen(view, datesGroup);
        assertOnScreen(view, flexibleDatesRadio);
        assertOnScreen(view, fixedDatesRadio);
        assertOnScreen(view, fixedDatesLayout);
        assertOnScreen(view, flexibleDatesLayout);
        assertOnScreen(view, submit);
    }

    private View getView(){
        return activity.getWindow().getDecorView();
    }
}
