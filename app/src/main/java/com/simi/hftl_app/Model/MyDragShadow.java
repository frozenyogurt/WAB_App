package com.simi.hftl_app.Model;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.View;

/**
 * Created by student on 02.03.2016.
 */
public class MyDragShadow extends View.DragShadowBuilder
{
    private final int halfOfDisplayWidth;
    private ColorDrawable box;

    public MyDragShadow(View view, int color, int halfOfDisplayWidth)
    {
        super(view);
        box = new ColorDrawable(color);
        this.halfOfDisplayWidth = halfOfDisplayWidth;
    }

    @Override
    public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint)
    {
        View view = getView();

        int height = view.getHeight();
        int width = view.getWidth();

        if (view.getWidth() > halfOfDisplayWidth)
        {
            width = width/2;
        }
        box.setBounds(0, 0, height, width);
        shadowSize.set(height, width);
        shadowTouchPoint.set((int)height/2, (int)width/2);
    }

    @Override
    public void onDrawShadow(Canvas canvas)
    {
        box.draw(canvas);
    }
}
