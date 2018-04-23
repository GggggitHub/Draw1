package com.hencoder.hencoderpracticedraw1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.beziertest.Pratcie2Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义view1
 * by zyj 2017-7-13 14:05:29
 * 参考文章：
 * http://mp.weixin.qq.com/s?__biz=MzIwNTczNTY0NA==&mid=2247483657&idx=1&sn=0e3a9f84d9924ef4125c885592dbb843&chksm=972d12baa05a9bac18af5d335d65eba9b71146a9fec143be6ecf62d4a4bd2e7179c726cdbb81&mpshare=1&scene=23&srcid=0713nncCUFGL3eOYjdlaKgdm#rd
 *
 * 执行顺序
 * 07-13 14:15:53.665 24836-24836/com.hencoder.hencoderpracticedraw1 I/MainActivity: LifeCircle: 属性
 * 07-13 14:15:53.665 24836-24836/com.hencoder.hencoderpracticedraw1 I/MainActivity: instance initializer:
 * 07-13 14:15:53.715 24836-24836/com.hencoder.hencoderpracticedraw1 I/MainActivity: onCreate:
 * 07-13 14:15:53.715 24836-24836/com.hencoder.hencoderpracticedraw1 I/MainActivity: onCreate: 2
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TabLayout tabLayout;
    ViewPager pager;
    LifeCircle circle = new LifeCircle();

    List<PageModel> pageModels = new ArrayList<>();
    FragmentPagerAdapter fragmentPagerAdapter;
    List<PageModel> pageModelBeziers = new ArrayList<>();

    {
        Log.i(TAG, "instance initializer: ");
        Log.i(TAG, "instance initializer: ");
//        pageModels.add(new PageModel(0x00, R.string.title_pathmorphing_bezier, R.layout.bezier_pathmorphing));
//        pageModelBeziers.add(new PageModel(0x00, R.string.title_pathmorphing_bezier, R.layout.bezier_pathmorphing));

        pageModels.add(new PageModel(R.layout.sample_color, R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.layout.sample_circle, R.string.title_draw_circle, R.layout.practice_circle));
        pageModels.add(new PageModel(R.layout.sample_rect, R.string.title_draw_rect, R.layout.practice_rect));
        pageModels.add(new PageModel(R.layout.sample_point, R.string.title_draw_point, R.layout.practice_point));
        pageModels.add(new PageModel(R.layout.sample_oval, R.string.title_draw_oval, R.layout.practice_oval));
        pageModels.add(new PageModel(R.layout.sample_line, R.string.title_draw_line, R.layout.practice_line));
        pageModels.add(new PageModel(R.layout.sample_round_rect, R.string.title_draw_round_rect, R.layout.practice_round_rect));
        pageModels.add(new PageModel(R.layout.sample_arc, R.string.title_draw_arc, R.layout.practice_arc));
        pageModels.add(new PageModel(R.layout.sample_path, R.string.title_draw_path, R.layout.practice_path));
        pageModels.add(new PageModel(R.layout.sample_histogram, R.string.title_draw_histogram, R.layout.practice_histogram));
        pageModels.add(new PageModel(R.layout.sample_pie_chart, R.string.title_draw_pie_chart, R.layout.practice_pie_chart));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        pager = (ViewPager) findViewById(R.id.pager);
        Log.i(TAG, "onCreate: 2");
        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.sampleLayoutRes, pageModel.practiceLayoutRes);
            }

            // Called when the host view is attempting to determine if an item's position has changed. Returns POSITION_UNCHANGED if the position of the given item has not changed or POSITION_NONE if the item is no longer present in the adapter.
//           @Override
//            public int getItemPosition(Object object) {
//                return POSITION_UNCHANGED;
//            }
//            从网上找到的解决办法是，覆写getItemPosition使其返POSITION_NONE，
//            以触发Fragment的销毁和重建。可是这将导致Fragment频繁的销毁和重建，并不是最佳的方法。
//            后来我把注意力放在了入口参数object上，"representing an item",
//            实际上就是Fragment，只需要为Fragment提供一个更新view的public方法：

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

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        };
        pager.setAdapter(fragmentPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

        //上拉悬停
        {
            findViewById(R.id.btn_pull_down).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this,PullActivity.class));
                }
            });
        }

        //贝塞尔曲线
        {
            findViewById(R.id.btn_bezier).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    startActivity(new Intent(MainActivity.this, Pratcie2Activity.class));
//                    pageModels.clear();
//                    pageModels.addAll(pageModelBeziers);
////                   pageModels=pageModelBeziers;
//                   fragmentPagerAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public class PageModel {
        int sampleLayoutRes;
        @StringRes
        int titleRes;
        @LayoutRes
        int practiceLayoutRes;

//        PageModel(@LayoutRes int sampleLayoutRes, @StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
        public PageModel(int sampleLayoutRes,@StringRes  int titleRes, @LayoutRes int practiceLayoutRes) {
            this.sampleLayoutRes = sampleLayoutRes;
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }

    class LifeCircle {
        public LifeCircle() {
            Log.i(TAG, "LifeCircle: 属性");
        }
    }
}
