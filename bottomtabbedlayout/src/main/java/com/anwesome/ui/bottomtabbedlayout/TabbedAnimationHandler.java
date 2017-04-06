package com.anwesome.ui.bottomtabbedlayout;

import android.animation.Animator;
import android.animation.ValueAnimator;

/**
 * Created by anweshmishra on 06/04/17.
 */
public class TabbedAnimationHandler  implements ValueAnimator.AnimatorUpdateListener,Animator.AnimatorListener{
    private TabbedLayout layout;
    private TabbedView newTab;
    private ValueAnimator yAnimator;
    public TabbedAnimationHandler(TabbedLayout layout,TabbedView newTab) {
        this.newTab = newTab;
        this.layout = layout;
        yAnimator = ValueAnimator.ofFloat(0,layout.getH());
        yAnimator.setDuration(250);
    }
    public void start() {
        if(yAnimator!=null) {
            yAnimator.start();
        }
    }
    public void onAnimationUpdate(ValueAnimator animator) {
        float y = (float)animator.getAnimatedValue();
        this.newTab.setY(y);
        layout.animateCurrTab(y);
    }
    public void onAnimationRepeat(Animator animator) {

    }
    public void onAnimationCancel(Animator animator) {

    }
    public void onAnimationEnd(Animator animator) {
        layout.setNewTab(newTab);
    }
    public void onAnimationStart(Animator animator) {

    }
}
