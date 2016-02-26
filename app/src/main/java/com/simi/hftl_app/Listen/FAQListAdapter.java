package com.simi.hftl_app.Listen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 14.02.2016.
 */
public class FAQListAdapter extends ArrayAdapter<FAQListItem>
{
    private final LayoutInflater inflater;
    private final ArrayList<FAQListItem> items;
    private final MainActivity activity;

    public FAQListAdapter (MainActivity activity, int resource, ArrayList<FAQListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.items = items;
        this.activity = activity;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.faq_list_item, parent, false);
        FAQListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.faq_item_name);
        name.setText(listItem.getName());

        TextView more = (TextView) view.findViewById(R.id.item_more);
        more.setText(activity.getResources().getString(R.string.FAQ_SEE_ANSWER));

        return view;
    }
}
