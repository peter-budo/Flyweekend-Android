package com.flyweekend.android.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.*;
import com.flyweekend.android.R;

public class FlightFragment extends Fragment {
    private Context context;
    private EditText budget;
    private EditText arrivalLocation;
    private EditText departureLocation;
    private RadioGroup flightRadioGrp;
    private RadioGroup dateTypeRadioGrp;
    private RelativeLayout returnFixedDays;
    private RelativeLayout returnFlexibleDays;
    private final Integer[] adult_values = {1, 2, 3, 4, 5, 6};
    private final Integer[] children_values = {0, 1, 2, 3};
    private Spinner adultsSpinner;
    private Spinner childrenSpinner;
    private Spinner infantsSpinner;
    private Spinner classSpinner;
    private final String TAG = "FlightFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.flight_tab, container, false);
        budget = budget(view);
        arrivalLocation = arrivalLocation(view);
        departureLocation = departureLocation(view);
        flightRadioGrp = flightRadioGroup(view);
        dateTypeRadioGrp = dateTypeRadioGroup(view);
        returnFixedDays = (RelativeLayout) view.findViewById(R.id.return_fixed_days_stub);
        returnFlexibleDays = (RelativeLayout) view.findViewById(R.id.return_flexible_days_stub);
        updateDatesVisibility();
        adultsSpinner = spinner(view, R.id.adults_spinner, adult_values);
        childrenSpinner = spinner(view, R.id.children_spinner, children_values);
        infantsSpinner = spinner(view, R.id.infants_spinner, children_values);
        classSpinner = spinner(view, R.id.class_spinner, getResources().getStringArray(R.array.travel_class_entries));
        Button submit = (Button)view.findViewById(R.id.submit);
        submit.setOnClickListener(new SubmitListener());
        return view;
    }

    private EditText budget(View view) {
        return (EditText)view.findViewById(R.id.budget);
    }

    private EditText arrivalLocation(View view){
        return (EditText) view.findViewById(R.id.arrivalLocation);
    }

    private EditText departureLocation(View view) {
        return (EditText)view.findViewById(R.id.departureLocation);
    }

    private RadioGroup flightRadioGroup(View view){
        RadioGroup group = (RadioGroup)view.findViewById(R.id.flight_radio_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int selected) {
                if(selected == R.id.return_flight_radio){
                    Log.i(TAG, "Return flight selected");
                }else{
                    Log.i(TAG, "One way flight selected");
                }
            }
        });
        return group;
    }

    private RadioGroup dateTypeRadioGroup(View view){
        RadioGroup group = (RadioGroup)view.findViewById(R.id.dates_radio_group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup radioGroup, int selected) {
                if(selected == R.id.flexible_dates_radio){
                    Log.i(TAG, "Flexible dates selected");
                    updateDatesVisibility();
                }else{
                    Log.i(TAG, "Fixed dates selected");
                    updateDatesVisibility();
                }
            }
        });
        return group;
    }

    private void updateDatesVisibility(){
        if(flightRadioGrp.getCheckedRadioButtonId() == R.id.return_flight_radio && dateTypeRadioGrp.getCheckedRadioButtonId() == R.id.fixed_dates_radio){
            returnFixedDays.setVisibility(View.VISIBLE);
            returnFlexibleDays.setVisibility(View.GONE);
        } else{
            returnFixedDays.setVisibility(View.GONE);
            returnFlexibleDays.setVisibility(View.VISIBLE);
        }
    }

    private Spinner spinner(View view, int id, Object[] values){
        Spinner spinner = (Spinner) view.findViewById(id);
        ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_spinner_item, values);
        spinner.setAdapter(adapter);
        return spinner;
    }

    private class SubmitListener implements View.OnClickListener {
        public void onClick(View view) {
            Uri uri = Uri.parse("http://www.volareweekend.com/search/flight/return/fix/MIL/LON/01052012/08052012/500.0/1/0/0/00:00-23:59/00:00-23:59/ECONOMY/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}