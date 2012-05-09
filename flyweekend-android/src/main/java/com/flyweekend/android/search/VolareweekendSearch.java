package com.flyweekend.android.search;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import com.flyweekend.android.R;

public class VolareweekendSearch extends Activity {

    private ProgressDialog dialog;
    private String url;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volareweekend_search);
        context = getApplicationContext();
        downloadData();
    }

    private void downloadData() {
        dialog = ProgressDialog.show(this, "Doing search for you...", "Please wait", true, false);
        Thread thread = new Thread();
        thread.start();
    }

    public void run(){
        WebView view = new WebView(this);
        view.loadUrl(getURL());
        //view.loadUrl(url);
    }

    private String getURL() {
        return "http://www.volareweekend.com/search/flight/return/fix/MIL/LON/01052012/08052012/500.0/1/0/0/00:00-23:59/00:00-23:59/ECONOMY/";
    }
}
