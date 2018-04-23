package com.hencoder.hencoderpracticedraw1.beziertest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.OvershootInterpolator;

/**
 * Created by 张英杰 on 2018/4/23.
 */

public class PathMorphingBezierView extends View implements View.OnClickListener {

    Path mPath;
    Paint mPaint;
    float mStartPointX;
    float mFlagPointOneX;
    float mFlagPointTwoX;
    float mEndPointX;
    float mStartPointY;
    float mFlagPointOneY;
    float mFlagPointTwoY;
    float mEndPointY;
    private ValueAnimator mValueAnimator;

    public PathMorphingBezierView(Context context) {
        super(context);
    }
    public PathMorphingBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(8);
        mPaint.setStyle(Paint.Style.STROKE);
    }
    public PathMorphingBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public PathMorphingBezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mFlagPointOneX = mStartPointX = w / 4;
        mFlagPointOneY = mStartPointY = h / 2 - 100;

        mFlagPointTwoX = mEndPointX = w * 3 / 4;
        mFlagPointTwoY = mEndPointY = h / 2 - 100;

        mPath=new Path();
        mValueAnimator = ValueAnimator.ofFloat(mStartPointY, h);
//        mValueAnimator.setInterpolator(new OvershootInterpolator());
        mValueAnimator.setDuration(3000);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               mFlagPointTwoY= mFlagPointOneY = (float) animation.getAnimatedValue();
               invalidate();
            }
        });

        setOnClickListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPath.reset();
        mPath.moveTo(mStartPointX,mStartPointY);
        mPath.cubicTo(mFlagPointOneX,mFlagPointOneY,mFlagPointTwoX,mFlagPointTwoY,mEndPointX,mEndPointY);

        canvas.drawPath(mPath,mPaint);


    }

    @Override
    public void onClick(View v) {
            mValueAnimator.start();
    }
}
