package com.simi.hftl_app.Listen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Person;
import com.simi.hftl_app.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 11.02.2016.
 */
public class PersonListAdapter extends ArrayAdapter<PersonListItem>
{
    private final LayoutInflater inflater;
    private final MainActivity activity;
    private final ArrayList<PersonListItem> items;

    public PersonListAdapter (MainActivity activity, int resource, ArrayList<PersonListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.about_us_list_item, parent, false);
        PersonListItem listItem = items.get(position);

        TextView name = (TextView) view.findViewById(R.id.person_name);
        name.setText(listItem.getName());

        TextView description = (TextView) view.findViewById(R.id.person_description);
        description.setText(listItem.getDescription());

        ImageView image = (ImageView) view.findViewById(R.id.person_image);
        if (listItem.getPerson().equals(Person.STEPHAN))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.stephan));
        }
        else if (listItem.getPerson().equals(Person.SIMION))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.simion));
        }
        else if (listItem.getPerson().equals(Person.FLORIAN))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.florian));
        }

        return view;
    }

    @Override
    public PersonListItem getItem(int position) {
        return items.get(position);
    }
}
