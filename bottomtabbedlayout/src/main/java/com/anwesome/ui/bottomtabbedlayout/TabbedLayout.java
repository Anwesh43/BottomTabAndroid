package com.anwesome.ui.bottomtabbedlayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 06/04/17.
 */
public class TabbedLayout extends ViewGroup {
    private TabbedView currView = null;
    private List<TabbedElement> tabbedElements = new ArrayList<>();
    private int w=100,h=100;
    final private int n = 5;
    public void onMeasure(int wspec,int hspec) {
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            measureChild(child,wspec,hspec);
        }
        setMeasuredDimension(w,h);
    }
    public void onLayout(boolean reloaded,int a,int b,int w,int h) {
        int x = 0,gap= w/(2*n),y = h-h/9;
        for(int i=0;i<getChildCount();i++) {
            View child = getChildAt(i);
            if(child instanceof TabbedView) {
                child.layout(0,0,w,h);
            }
            else if(child instanceof BottomButton){
                child.layout(x,y,x+gap,y+gap);
                x+=(2*gap);
            }
        }
    }
    public float getH() {
        return h;
    }
    public void addTab(Bitmap icon,TabbedView tabbedView) throws Exception{
        if(tabbedElements.size()<n) {
            BottomButton bottomButton = new BottomButton(getContext(), icon);
            addView(bottomButton, new LayoutParams(w / (2*n), w / (2*n)));
            if (currView == null && tabbedElements.size() == 0) {
                currView = tabbedView;
                currView.setX(0);
                currView.setY(0);
                addView(currView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            }
            TabbedElement tabbedElement = new TabbedElement(bottomButton, tabbedView,this);
            tabbedElements.add(tabbedElement);
            requestLayout();
        }
        else {
            throw new Exception("can add more than 4 tabs");
        }

    }
    public TabbedLayout(Context context) {
        super(context);
        initDimension();
    }
    public void initDimension() {
        Context context = getContext();
        DisplayManager displayManager = (DisplayManager)context.getSystemService(Context.DISPLAY_SERVICE);
        Display display = displayManager.getDisplay(0);
        if(display!=null) {
            Point size = new Point();
            display.getRealSize(size);
            w = size.x;
            h = size.y;
        }

    }
    public TabbedLayout(Context context, AttributeSet attrs) {
        super(context,attrs);
        initDimension();
    }
    public void animateCurrTab(float y) {
        if(currView!=null) {
            currView.setY(h-y);
        }
    }
    public void setNewTab(TabbedView newTab) {
        if(currView == null) {
            removeView(currView);
            currView = newTab;
            addView(currView,new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        }
    }
}
