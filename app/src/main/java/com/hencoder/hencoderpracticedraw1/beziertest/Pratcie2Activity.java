package com.hencoder.hencoderpracticedraw1.beziertest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hencoder.hencoderpracticedraw1.MPageModel;
import com.hencoder.hencoderpracticedraw1.R;

import java.util.ArrayList;
import java.util.List;

public class Pratcie2Activity extends AppCompatActivity {
    private static final String TAG = "Pratcie2Activity";
    TabLayout tabLayout;
    ViewPager pager;
    List<MPageModel> pageModels = new ArrayList<>();

    {
        Log.i(TAG, "instance initializer: ");

        pageModels.add(new MPageModel(0x00, R.string.title_pathmorphing_bezier, R.layout.bezier_pathmorphing));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratcie2);
        Log.i(TAG, "onCreate: ");
        pager = (ViewPager) findViewById(R.id.pager);
        FragmentPagerAdapter fragmentStatePagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                MPageModel pageModel = pageModels.get(position);
                return MPageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
//            @Override
//            public int getItemPosition(Object object) {
//
////                if (object instanceof PageFragment) {
////                    ((PageFragment) object).updateDate();
//////                }
////                return super.getItemPosition(object);
////                return POSITION_UNCHANGED;
//                return POSITION_NONE;
//            }
        };
        pager.setAdapter(fragmentStatePagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);
//        fragmentStatePagerAdapter.notifyDataSetChanged();

    }
}
