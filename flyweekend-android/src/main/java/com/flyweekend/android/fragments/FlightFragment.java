package com.flyweekend.android.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.flyweekend.android.R;
import com.flyweekend.android.search.VolareweekendSearch;

public class FlightFragment extends Fragment {
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        View view = inflater.inflate(R.layout.flight_tab, container, false);
        Button submit = (Button)view.findViewById(R.id.submit);
        submit.setOnClickListener(new SubmitListener());
        return view;
    }

    private class SubmitListener implements View.OnClickListener {
        public void onClick(View view) {
            Uri uri = Uri.parse("http://www.volareweekend.com/search/flight/return/fix/MIL/LON/01052012/08052012/500.0/1/0/0/00:00-23:59/00:00-23:59/ECONOMY/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}