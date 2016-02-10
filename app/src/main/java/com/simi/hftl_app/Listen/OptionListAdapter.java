package com.simi.hftl_app.Listen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Option;
import com.simi.hftl_app.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 10.02.2016.
 */
public class OptionListAdapter extends ArrayAdapter<OptionListItem>
{
    private final LayoutInflater inflater;
    private final MainActivity activity;
    private final ArrayList<OptionListItem> items;

    public OptionListAdapter (MainActivity activity, int resource, ArrayList<OptionListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.option_list_item, parent, false);
        OptionListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.item_option_name);
        name.setText(listItem.getName());

        ImageView image = (ImageView) view.findViewById(R.id.item_option_image);
        if (listItem.getOption().equals(Option.ABOUTUS))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.info));
        }
        else if (listItem.getOption().equals(Option.EXIT))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.close));
        }
        else if (listItem.getOption().equals(Option.SETTINGS))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.setting));
        }
        else
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.www));
        }

        return view;
    }

    @Override
    public OptionListItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public void remove(OptionListItem object)
    {
        items.remove(object);
        notifyDataSetChanged();
    }

    @Override
    public void add(OptionListItem object)
    {
        items.add(object);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items == null ? 0 : items.size();
    }

}