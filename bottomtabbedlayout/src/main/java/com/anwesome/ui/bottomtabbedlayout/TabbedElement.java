package com.anwesome.ui.bottomtabbedlayout;


/**
 * Created by anweshmishra on 06/04/17.
 */
public class TabbedElement {
    private TabbedView tabbedView;
    private BottomButton bottomButton;
    public TabbedElement(BottomButton bottomButton, TabbedView tabbedView) {
        this.bottomButton = bottomButton;
        this.tabbedView = tabbedView;
    }
}
