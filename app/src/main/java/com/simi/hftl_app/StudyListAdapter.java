package com.simi.hftl_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 10.02.2016.
 */
public class StudyListAdapter extends ArrayAdapter <StudyListItem>
{

    private final LayoutInflater inflater;
    private final MainActivity activity;
    private final ArrayList<StudyListItem> items;

    public StudyListAdapter(MainActivity activity, int resource, ArrayList<StudyListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.study_list_item, parent, false);

        StudyListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.item_name);
        name.setText(listItem.getName());

        return view;
    }

    @Override
    public StudyListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public void remove(StudyListItem object)
    {
        items.remove(object);
        notifyDataSetChanged();
    }

    @Override
    public void add(StudyListItem object)
    {
        items.add(object);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

}
