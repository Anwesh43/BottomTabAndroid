package com.anwesome.ui.bottomtabbedlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by anweshmishra on 06/04/17.
 */
public class BottomButton extends View{
    private Bitmap bitmap;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int time = 0;
    public BottomButton(Context context, Bitmap bitmap) {
        super(context);
        this.bitmap = bitmap;
    }
    public void onDraw(Canvas canvas) {
        int w = canvas.getWidth(), h = canvas.getHeight();
        if(time == 0) {
            bitmap = Bitmap.createScaledBitmap(bitmap, w/2+w/10, h/2+h/10, true);
        }
        paint.setColor(Color.WHITE);
        Path path = new Path();
        path.addCircle(w/2,h/2,w/2, Path.Direction.CCW);
        canvas.drawPath(path,paint);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,w/2-bitmap.getWidth()/2,h/2-bitmap.getHeight()/2,paint);
        time++;
    }
}
