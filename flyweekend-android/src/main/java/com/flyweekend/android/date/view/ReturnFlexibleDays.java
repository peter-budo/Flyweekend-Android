package com.flyweekend.android.date.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.flyweekend.android.R;

public class ReturnFlexibleDays extends RelativeLayout{
    private Context context;
    private Spinner arrivalDay;
    private Spinner arrivalTime;
    private Spinner returnDay;
    private Spinner returnTime;

    public ReturnFlexibleDays(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.return_flexible_days, this);

        arrivalDay = spinner(view, R.id.arrival_day_spinner, R.array.travel_days_entries);
        arrivalTime = spinner(view, R.id.arrival_time_spinner, R.array.travel_time_entries);
        returnDay = spinner(view, R.id.return_day_spinner, R.array.travel_days_entries);
        returnTime = spinner(view, R.id.return_time_spinner, R.array.travel_time_entries);
    }

    private Spinner spinner(View view, int id, int resource){
        Spinner spinner = (Spinner) view.findViewById(id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, resource, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        return spinner;
    }
}
