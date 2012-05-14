package com.flyweekend.android.date.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import com.flyweekend.android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReturnFixedDays extends RelativeLayout {
    private Context context;

    public ReturnFixedDays(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.return_fixed_days, this);
        TextView arrivalLabel = (TextView) view.findViewById(R.id.arrival_date_label);
    }
}
