package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        // TODO: 2017/7/19 如何偏移圆心
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        canvas.drawArc(290,190,590,490,180,120,true,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(300,200,600,500,-60,90,true,paint);
        paint.setColor(Color.GREEN);
        canvas.drawArc(300,200,600,500,35,48,true,paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(300,200,600,500,88,92,true,paint);
    }
}
