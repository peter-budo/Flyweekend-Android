package com.flyweekend.android;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import de.akquinet.android.androlog.Log;
import net.peterkuterna.android.apps.swipeytabs.SwipeyTabFragment;
import net.peterkuterna.android.apps.swipeytabs.SwipeyTabs;
import net.peterkuterna.android.apps.swipeytabs.SwipeyTabsAdapter;

public class FlyweekendActivity extends FragmentActivity {

    private SwipeyTabs tabs;
    private ViewPager pager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initializes the logging
        Log.init();
        setContentView(R.layout.activity_swipeytab);

        pager = (ViewPager) findViewById(R.id.viewpager);
        tabs = (SwipeyTabs) findViewById(R.id.swipeytabs);

        TabsAdapter adapter = new TabsAdapter(this, getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setAdapter(adapter);
        pager.setOnPageChangeListener(tabs);
        pager.setCurrentItem(0);
    }

    private class TabsAdapter extends FragmentPagerAdapter implements SwipeyTabsAdapter{
        private final Context mContext;

        public TabsAdapter(Context context, FragmentManager fragmentManager) {
            super(fragmentManager);
            mContext = context;
        }

        @Override
        public Fragment getItem(int index) {
            return SwipeyTabFragment.newInstance(tabNameAt(index));
        }

        @Override
        public int getCount() {
            return tabTitles().length;
        }

        public TextView getTab(final int position, SwipeyTabs root) {
            TextView view = (TextView) LayoutInflater.from(mContext).inflate(R.layout.swipey_tab_indicator, root, false);
            view.setText(tabNameAt(position));
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    pager.setCurrentItem(position);
                }
            });
            return view;
        }

        private String tabNameAt(int index){
            return tabTitles()[index];
        }

        private String[] tabTitles(){
            return mContext.getResources().getStringArray(R.array.tab_titles);
        }
    }
}

