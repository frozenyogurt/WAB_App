package com.simi.hftl_app.Model;

import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 02.03.2016.
 */
public class MyDragListener implements View.OnDragListener
{
    private MainActivity activity;
    private int color;

    public MyDragListener (MainActivity activity, int color)
    {
        this.activity = activity;
        this.color = color;
    }

    @Override
    public boolean onDrag(View droppedView, DragEvent event)
    {
        View draggedView = (View) event.getLocalState();
        switch (event.getAction())
        {
            case DragEvent.ACTION_DRAG_STARTED:
                break;

            case DragEvent.ACTION_DRAG_ENTERED:
                if (draggedView.getId() != droppedView.getId())
                {
                    droppedView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.hover_background));
                }
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                if (draggedView.getId() != droppedView.getId() && activity.getColor() == null)
                {
                    droppedView.setBackgroundColor(this.color);
                }
                else if (draggedView.getId() != droppedView.getId() && activity.getColor() != null)
                {
                    droppedView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.bordered_magenta));
                    ((Button)droppedView).setTextColor(activity.getResources().getColor(R.color.magenta));
                }
                break;

            case DragEvent.ACTION_DROP:
                if (activity.getColor() != null)
                {
                    droppedView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.bordered_magenta));
                    ((Button)droppedView).setTextColor(activity.getResources().getColor(R.color.magenta));
                }
                if (draggedView.getId() != droppedView.getId())
                {
                    droppedView.setVisibility(View.GONE);
                    draggedView.setVisibility(View.GONE);
                    LinearLayout owner = (LinearLayout) draggedView.getParent();
                    owner.setLayoutTransition(null);
                    owner.removeView(draggedView);
                    owner.invalidate();

                    LinearLayout container = (LinearLayout) droppedView.getParent();
                    container.setLayoutTransition(null);
                    container.removeView(droppedView);
                    container.invalidate();

                    draggedView.setVisibility(View.VISIBLE);
                    droppedView.setVisibility(View.VISIBLE);
                    if (activity.getColor() == null)
                    {
                        droppedView.setBackgroundColor(this.color);
                    }
                    owner.addView(droppedView);
                    container.addView(draggedView);
                }
                break;

            case DragEvent.ACTION_DRAG_ENDED:
                if (activity.getColor() == null)
                {
                    droppedView.setBackgroundColor(this.color);
                }
                else if (activity.getColor() != null)
                {
                    droppedView.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.bordered_magenta));
                    ((Button)droppedView).setTextColor(activity.getResources().getColor(R.color.magenta));
                }
                break;

            default:
                break;
        }
        return true;
    }
}
