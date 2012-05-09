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
import android.widget.*;
import com.flyweekend.android.R;

public class FlightFragment extends Fragment {
    private Context context;
    private EditText budget;
    private EditText arrivalLocation;
    private EditText departureLocation;
    private RadioGroup flightRadioGrp;
    private RadioGroup dateTypeRadioGrp;
    private RelativeLayout fixedSelection;
    private RelativeLayout flexibleSelection;
    private final String TAG = "FlightFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.flight_tab, container, false);
        budget = budget(view);
        arrivalLocation = arrivalLocation(view);
        departureLocation = departureLocation(view);
        //view.findViewById(R.id.flight_label);
        flightRadioGrp = flightRadioGroup(view);
        dateTypeRadioGrp = dateTypeRadioGroup(view);
        fixedSelection = getLayout(view, R.id.fixed_dates_layout, fixedDatesSelected());
        flexibleSelection = getLayout(view, R.id.flexible_dates_layout, !fixedDatesSelected());
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
                if(selected == R.id.return_flight){
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
                if(selected == R.id.flexible_dates){
                    Log.i(TAG, "Flexible dates selected");
                    updateDatesLayout(selected);
                }else{
                    Log.i(TAG, "Fixed dates selected");
                    updateDatesLayout(selected);
                }
            }
        });
        return group;
    }

    private RelativeLayout getLayout(View view, int id, boolean visible){
        RelativeLayout layout = (RelativeLayout)view.findViewById(id);
        if(visible){
            layout.setVisibility(View.VISIBLE);
        }else {
            layout.setVisibility(View.INVISIBLE);
        }
        return layout;
    }

    private void updateDatesLayout(int selected){
        if(selected == R.id.flexible_dates){
            fixedSelection.setVisibility(View.INVISIBLE);
            flexibleSelection.setVisibility(View.VISIBLE);
        }else{
            fixedSelection.setVisibility(View.VISIBLE);
            flexibleSelection.setVisibility(View.INVISIBLE);
        }
    }

    private boolean fixedDatesSelected(){
        return dateTypeRadioGrp.getCheckedRadioButtonId() == R.id.fixed_dates;
    }

    private class SubmitListener implements View.OnClickListener {
        public void onClick(View view) {
            Uri uri = Uri.parse("http://www.volareweekend.com/search/flight/return/fix/MIL/LON/01052012/08052012/500.0/1/0/0/00:00-23:59/00:00-23:59/ECONOMY/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}