package com.anwesome.ui.bottomtabbedlayout;


import android.view.View;

/**
 * Created by anweshmishra on 06/04/17.
 */
public class TabbedElement {
    private TabbedView tabbedView;
    private BottomButton bottomButton;
    public TabbedElement(BottomButton bottomButton, final TabbedView tabbedView, final TabbedLayout tabbedLayout) {
        this.bottomButton = bottomButton;
        this.tabbedView = tabbedView;
        this.bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TabbedAnimationHandler tabbedAnimationHandler = new TabbedAnimationHandler(tabbedLayout,tabbedView);
                tabbedAnimationHandler.start();
            }
        });
    }
}
