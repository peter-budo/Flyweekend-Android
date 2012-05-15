package com.flyweekend.android.date.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.flyweekend.android.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReturnFixedDays extends RelativeLayout {
    private Context context;
    private EditText arrivalDate;
    private Spinner arrivalTime;
    private EditText returnDate;
    private Spinner returnTime;
    private final String pattern = "dd/MM/yyyy";

    public ReturnFixedDays(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.return_fixed_days, this);

        arrivalDate = editText(view, R.id.arrival_date, arrivalDate());

        arrivalTime = spinner(view, R.id.arrival_time_spinner);

        returnDate = editText(view, R.id.return_date, returnDate());

        returnTime = spinner(view, R.id.return_time_spinner);
    }

    private EditText editText(View view, int id, String dateString) {
        EditText editText = (EditText) view.findViewById(id);
        editText.setText(dateString);
        return editText;
    }

    private Spinner spinner(View view, int id){
        Spinner spinner = (Spinner) view.findViewById(id);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.travel_time_entries, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        return spinner;
    }

    private String arrivalDate(){
        return dateToString(today());
    }

    private String returnDate(){
        return dateToString(weekLater());
    }

    private String dateToString(Date date){
        return formatter().format(date);
    }

    private SimpleDateFormat formatter(){
        return new SimpleDateFormat(pattern);
    }

    private Date weekLater(){
        return adjustDateBy(today(), 7);
    }

    private Date today(){
        return Calendar.getInstance().getTime();
    }

    private Date adjustDateBy(Date currentDate, int numOfDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, numOfDays);

        return calendar.getTime();

    }

}
