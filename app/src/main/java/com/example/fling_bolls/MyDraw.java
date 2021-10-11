package com.example.fling_bolls;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        //(float)(Math.random())
    }

    Paint p = new Paint();
    float x = 200f;
    float y = 200f;
    float vx = 1;
    float vy = 2;
    boolean onEdge = false;
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        p.setStrokeWidth(5);
        p.setColor(Color.YELLOW);
        canvas.drawCircle(x,y,50, p);
        if(x > getWidth() || x < 0){
            vx = -vx;
        }
        if(y > getHeight() || y < 0){
            vy = -vy;
        }
        x += vx;
        y += vy;
        invalidate();
    }

}
