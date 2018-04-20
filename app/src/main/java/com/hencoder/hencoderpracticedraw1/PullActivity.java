package com.hencoder.hencoderpracticedraw1;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author zyj 2018-4-20
 * @function 测试上拉悬停
 */
public class PullActivity extends AppCompatActivity {
    private static final String TAG = "PullActivity";
    private TextView tvTitle, tvContent,tvTitle2;
    private ImageView ivHead;
    private NestedScrollView nestScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pull);
        nestScrollView = (NestedScrollView) findViewById(R.id.nestscrollview);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle2 = (TextView) findViewById(R.id.tv_title2);
        tvContent = (TextView) findViewById(R.id.tv_content);
//        int color = ContextCompat.getColor(getActivity().getApplicationContext(), R.color.colorPrimary) &
//                0x00ffffff;
//        mRlTopBar.setBackgroundColor(((255 * mScrollY / h) << 24) | color);
        nestScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int[] location = new int[2];
                tvTitle.getLocationOnScreen(location);
                  /* tvTitle就是要悬浮的view，getLocationOnScreen（location）这个方法就是拿到view在屏幕中的位置 ，
                  传入一个数组，最后得到的yPosition就是view在屏幕中的高度，这里面调用了native层的实现方式，所以数组能直接附上值*/
                // 值得注意的是，拿到的这个高度还包括状态栏的高度。只要减掉就可以了，状态栏的高度获取获取附上代码:

                int xPosition = location[0];
                int yPosition = location[1];
                Log.d("ScrollViewActivity", "yPosition:" + yPosition);
                int statusBarHeight = getStatusBarHeight();
                Log.d("ScrollViewActivity", "statusBarHeight:" + statusBarHeight);
                if (yPosition <= statusBarHeight) {
                    tvTitle2.setVisibility(View.VISIBLE);
                    ivHead.setVisibility(View.GONE);
                } else {
                    tvTitle2.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * 状态栏的高度
     * @return
     */
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i(TAG, "onWindowFocusChanged: hasFocus== " + hasFocus);
        if (hasFocus) {
            if (ivHead != null) {
                Log.i(TAG, "onWindowFocusChanged: === ivHead "+ivHead.getY());
            }  if (tvTitle != null) {
                Log.i(TAG, "onWindowFocusChanged: === tvTitle "+tvTitle.getY());
            }  if (tvContent != null) {
                Log.i(TAG, "onWindowFocusChanged: === tvContent "+tvContent.getY());
            }
        }
    }
}
