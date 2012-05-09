package com.flyweekend.android;

import android.support.v4.app.FragmentActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import com.jayway.android.robotium.solo.Solo;

import static android.test.ViewAsserts.assertOnScreen;

public class FlyweekendActivityIT extends ActivityInstrumentationTestCase2<FlyweekendActivity> {

    private FragmentActivity activity;
    private Solo solo;

    public FlyweekendActivityIT() {
        super("com.flyweekend.android",FlyweekendActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = this.getActivity();
        solo = new Solo(getInstrumentation(), activity);
    }

    public void testActivity() {
        assertNotNull(activity);
    }

    public void testInitialView(){
        final View view = decorView();
        assertOnScreen(view, view.findViewById(R.id.viewpager));
        assertOnScreen(view, view.findViewById(R.id.swipeytabs));
    }

    private View decorView(){
        return activity.getWindow().getDecorView();
    }
}

