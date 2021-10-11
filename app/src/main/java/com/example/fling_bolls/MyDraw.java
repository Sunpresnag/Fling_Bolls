package com.example.fling_bolls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    Paint p = new Paint();
    float[] x = new float[200];
    float[] y = new float[200];

    int n = 0;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x[n] = event.getX();
        y[n] = event.getY();
        n++;
        return false;

    }

    float vx = 1;
    float vy = 2;
    boolean onEdge = false;
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setStrokeWidth(5);
        p.setColor(Color.YELLOW);
        for(int i = 0; i < 200; i++){
            canvas.drawCircle(x[i],y[i],50, p);
            if(x[i] > getWidth() || x[i] < 0){
                vx = -vx;
            }
            if(y[i] > getHeight() || y[i] < 0){
                vy = -vy;
            }
            x[i] += vx;
            y[i] += vy;
        }

        invalidate();
    }

}
