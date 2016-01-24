package com.github.farafonoff.advancedviews.dummy;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Artem_Farafonov on 12/21/2015.
 */
public class ScrollingFABBehavior extends FloatingActionButton.Behavior {
    //private int toolbarHeight;

    public ScrollingFABBehavior(Context context, AttributeSet attrs) {
        super();
        //this.toolbarHeight = Utils.getToolbarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        return super.layoutDependsOn(parent, fab, dependency) || (dependency instanceof AppBarLayout);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, FloatingActionButton fab, View dependency) {
        boolean returnValue = super.onDependentViewChanged(parent, fab, dependency);
        if (dependency instanceof AppBarLayout) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = fab.getHeight() + fabBottomMargin;
            //float ratio = (float)dependency.getY()/(float)toolbarHeight;
            float ratio = (float)dependency.getY()/(float)dependency.getHeight();
            fab.setTranslationY(-distanceToScroll * ratio);
        }
        return returnValue;
    }
}
