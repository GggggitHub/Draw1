package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {

    public Practice4DrawPointView(Context context) {
        super(context);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        Paint paint=new Paint();
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(20);
        canvas.drawPoint(100,100,paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(300,100,paint);

        float[] points = {
                50, 0,
                50, 50,
                50, 100,
                100, 50,
                100, 100};
        canvas.drawPoints(points,paint);
        paint.setColor(Color.BLUE);
        float[] points1 = {
                200,100,
                200,200,
                200,300,
                200,400,
                200,500,
                200,600
        };
        canvas.drawPoints(points1,paint);
        paint.setColor(Color.BLACK);
        float[] points2 = {
                300,100,
                300,200,
                300,300,
                300,400,
                300,500,
                300,600
        };
        canvas.drawPoints(points2,2,4,paint);


    }
}
