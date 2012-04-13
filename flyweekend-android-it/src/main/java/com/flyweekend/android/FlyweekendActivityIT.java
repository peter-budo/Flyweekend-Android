package com.flyweekend.android;

import android.test.ActivityInstrumentationTestCase2;

public class FlyweekendActivityIT extends ActivityInstrumentationTestCase2<FlyweekendActivity> {

    private FlyweekendActivity activity;

    public FlyweekendActivityIT() {
        super("com.flyweekend.android",FlyweekendActivity.class);
    }

    @Override
    protected void setUp() throws Exception{
        super.setUp();
        activity = this.getActivity();

    }

    public void testActivity() {
        assertNotNull(activity);
    }
}

