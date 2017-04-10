package com.anwesome.ui.bottomtabbedlayoutdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.anwesome.ui.bottomtabbedlayout.TabbedLayout;
import com.anwesome.ui.bottomtabbedlayout.TabbedView;

public class MainActivity extends AppCompatActivity {
    private Bitmap[] bitmaps = new Bitmap[4];
    private String backColors[] = {"#4DD0E1","#3949AB","#7B1FA2","#00695C"};
    private String circleColors[] = {"#388E3C","#00897B","#C2185B","#FF6E40"};
    private TabbedLayout tabbedLayout;
    private int res[] = {R.drawable.delivered,R.drawable.home,R.drawable.onway,R.drawable.order};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabbedLayout = new TabbedLayout(this);
        for(int i=0;i<res.length;i++) {
            bitmaps[i] = BitmapFactory.decodeResource(getResources(),res[i]);
        }
        for(int i=0;i<res.length;i++) {
            final int index =i;
            try {
                tabbedLayout.addTab(bitmaps[i], new CustomTabbedView(this) {
                    public int getBackColor() {
                        return Color.parseColor(backColors[index]);
                    }

                    public int getCircleColor() {
                        return Color.parseColor(circleColors[index]);
                    }
                });
            }
            catch (Exception ex) {

            }
        }
        setContentView(tabbedLayout);
    }
}
