package com.flyweekend.android.date.view;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.flyweekend.android.FlyweekendActivity;
import com.flyweekend.android.R;

import static android.test.ViewAsserts.assertOnScreen;

public class ReturnFixedDaysIT extends ActivityInstrumentationTestCase2<FlyweekendActivity> {
    private FlyweekendActivity activity;
    private TextView arrivalDateLabel;
    private EditText arrivalDate;
    private Spinner arrivalTimesSpinner;
    private TextView returnDateLabel;
    private EditText returnDate;
    private Spinner returnTimesSpinner;

    public ReturnFixedDaysIT() {
        super("com.flyweekend.android", FlyweekendActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = this.getActivity();
        arrivalDateLabel = (TextView) activity.findViewById(R.id.arrival_date_label);
        arrivalDate = (EditText) activity.findViewById(R.id.arrival_date);
        arrivalTimesSpinner = (Spinner) activity.findViewById(R.id.arrival_time_spinner);
        returnDateLabel = (TextView) activity.findViewById(R.id.return_date_label);
        returnDate = (EditText) activity.findViewById(R.id.return_date);
        returnTimesSpinner = (Spinner) activity.findViewById(R.id.return_time_spinner);
    }

    @UiThreadTest
    public void testInitialLayoutView(){
        assertNotNull(activity);
        final View view = getView();
        assertOnScreen(view, arrivalDateLabel);
        assertOnScreen(view, arrivalDate);
        assertOnScreen(view, arrivalTimesSpinner);
        int height = view.getHeight();
        int width = view.getWidth();
        view.scrollTo(height, width);
        assertOnScreen(view, returnDateLabel);
        assertOnScreen(view, returnDate);
        assertOnScreen(view, returnTimesSpinner);
    }

    private View getView(){
        return activity.getWindow().getDecorView();
    }
}
