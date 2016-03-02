package com.simi.hftl_app.Model;

import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.simi.hftl_app.Main.MainActivity;

/**
 * Created by student on 02.03.2016.
 */
public class MyLongClickListener implements View.OnLongClickListener
{
    private final int halfOfDisplayWidth;
    private MainActivity activity;

    public MyLongClickListener (int halfOfDisplayWidth, MainActivity activity)
    {
        this.activity = activity;
        this.halfOfDisplayWidth = halfOfDisplayWidth;
    }

    @Override
    public boolean onLongClick(View v)
    {
        Toast toast = Toast.makeText(this.activity.getApplicationContext(), "Die Box auf die gewünschte Position verschieben.", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM,0,0);
        toast.show();
        ClipData data = ClipData.newPlainText("", "");
        ColorDrawable color = (ColorDrawable) v.getBackground();
        v.startDrag(data, new MyDragShadow(v, color.getColor(), halfOfDisplayWidth), v, 0);
        v.setBackgroundColor(Color.WHITE);
        return false;
    }
}
