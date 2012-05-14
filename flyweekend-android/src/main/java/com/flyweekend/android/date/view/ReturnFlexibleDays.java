package com.flyweekend.android.date.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.flyweekend.android.R;

public class ReturnFlexibleDays extends RelativeLayout{
    private TextView arrivalDaysLabel;

    public ReturnFlexibleDays(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.return_flexible_days, this);

        arrivalDaysLabel = (TextView) view.findViewById(R.id.arrival_days_label);
    }
}
