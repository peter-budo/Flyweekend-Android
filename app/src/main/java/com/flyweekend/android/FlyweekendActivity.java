package com.flyweekend.android;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.flyweekend.android.fragments.FlightFragment;
import com.flyweekend.android.fragments.HotelFragment;
import net.peterkuterna.android.apps.swipeytabs.SwipeyTabs;
import net.peterkuterna.android.apps.swipeytabs.SwipeyTabsAdapter;

import java.util.ArrayList;
import java.util.List;

public class FlyweekendActivity extends FragmentActivity {

    private SwipeyTabs tabs;
    private ViewPager pager;

    private List<Fragment> fragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipeytab);

        pager = (ViewPager) findViewById(R.id.viewpager);
        tabs = (SwipeyTabs) findViewById(R.id.swipeytabs);

        fragments = new ArrayList<Fragment>() {
            {
                add(Fragment.instantiate(getContext(), FlightFragment.class.getName()));
                add(Fragment.instantiate(getContext(), HotelFragment.class.getName()));
            }
        };

        TabsAdapter adapter = new TabsAdapter(this, getSupportFragmentManager(), fragments);
        pager.setAdapter(adapter);
        tabs.setAdapter(adapter);
        pager.setOnPageChangeListener(tabs);
        pager.setCurrentItem(0);
    }

    private Context getContext() {
        return getApplicationContext();
    }

    private class TabsAdapter extends FragmentPagerAdapter implements SwipeyTabsAdapter {
        private final Context mContext;
        private final List<Fragment> mFragments;

        public TabsAdapter(Context context, FragmentManager fragmentManager, List<Fragment> fragments) {
            super(fragmentManager);
            mContext = context;
            mFragments = fragments;
        }

        @Override
        public Fragment getItem(int index) {
            return mFragments.get(index);
        }

        @Override
        public int getCount() {
            return mFragments.size();
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

        private String tabNameAt(int index) {
            return tabTitles()[index];
        }

        private String[] tabTitles() {
            return mContext.getResources().getStringArray(R.array.tab_titles);
        }
    }
}

