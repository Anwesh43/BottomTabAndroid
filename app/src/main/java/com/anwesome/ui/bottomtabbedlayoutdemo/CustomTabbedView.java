package com.anwesome.ui.bottomtabbedlayoutdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.anwesome.ui.bottomtabbedlayout.TabbedView;

/**
 * Created by anweshmishra on 06/04/17.
 */
public class CustomTabbedView extends TabbedView {
    public CustomTabbedView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(getBackColor());
        int w = canvas.getWidth(),h = canvas.getHeight();
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(getCircleColor());
        canvas.drawCircle(w/2,h/2,w/4,paint);
    }
    public int getBackColor() {
        return Color.RED;
    }
    public int getCircleColor() {
        return Color.GREEN;
    }
}
