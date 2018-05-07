package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public class Practice1DrawColorView extends View {

    public Practice1DrawColorView(Context context) {
        super(context);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private static final String TAG = "Practice1DrawColorView";
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode    = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode    = MeasureSpec.getMode(heightMeasureSpec);

        Log.e(TAG,"width    -- mode: "+MeasureSpec.getMode(widthMode) +" size: "+MeasureSpec.getSize(widthMeasureSpec));
        Log.e(TAG,"height    -- mode: "+MeasureSpec.getMode(heightMode) +" size: "+MeasureSpec.getSize(heightMeasureSpec));


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色
//        黄色： Color.YELLOW

        canvas.drawColor(Color.YELLOW);

        int height = canvas.getHeight();
        int width = canvas.getWidth();


        Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(Color.GREEN);
        paint2.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(0,0,width,height/2),paint2);

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#22888888"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(0,0,width/2,height),paint);
    }
}
