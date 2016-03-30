package com.simi.hftl_app.Listen;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

public class ExpandableFAQListAdapter extends BaseExpandableListAdapter
{
    private MainActivity activity;
    private ArrayList<FAQListItem> items;

    public ExpandableFAQListAdapter(MainActivity activity, ArrayList<FAQListItem> listDataHeader)
    {
        this.activity = activity;
        this.items = listDataHeader;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon)
    {
        return items.get(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {

        final String childText = ((FAQListItem)getChild(groupPosition, childPosition)).getInfo();

        if (convertView == null)
        {
            LayoutInflater infalInflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.faq_info_item, null);
        }

        TextView infoText = (TextView) convertView.findViewById(R.id.faq_text);
        infoText.setText(childText);
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            infoText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return items.get(groupPosition);
    }

    @Override
    public int getGroupCount()
    {
        return items.size();
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String title = ((FAQListItem) getGroup(groupPosition)).getName();

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) this.activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_list_item, null);
        }

        TextView titleText = (TextView) convertView.findViewById(R.id.faq_item_name);
        titleText.setText(title);
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            titleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            titleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            titleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return convertView;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }
}