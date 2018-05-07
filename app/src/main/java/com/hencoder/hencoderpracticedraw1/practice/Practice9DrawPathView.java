package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        Path path = new Path(); // 初始化 Path 对象

        RectF rectF = new RectF(200, 200, 400, 400);
        path.addArc(rectF, -225, 225);//左圆弧
        RectF rectF2 = new RectF(400, 200, 600, 400);
        path.arcTo(rectF2, -180, 225, false);//右圆弧
        path.lineTo(400, 542);//到当前位置画直线
        Paint paint = new Paint();
        canvas.drawPath(path,paint);
    }
}
