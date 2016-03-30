package com.simi.hftl_app.Listen;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Person;
import com.simi.hftl_app.Model.TextSize;
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
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.person_list_item, parent, false);
        PersonListItem listItem = items.get(position);

        TextView sendMailText = (TextView) view.findViewById(R.id.send_mail_text);
        sendMailText.setText(activity.getResources().getString(R.string.SEND_MAIL));

        TextView name = (TextView) view.findViewById(R.id.person_name);
        name.setText(listItem.getName());

        TextView description = (TextView) view.findViewById(R.id.person_description);
        description.setText(listItem.getDescription());

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_middle));
            description.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size));
            description.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            name.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            sendMailText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.default_button_text_size_big));
            description.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        final ImageView image = (ImageView) view.findViewById(R.id.person_image);
        if (listItem.getPerson().equals(Person.STEPHAN))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.stephan));
            image.setTag(R.drawable.stephan);
        }
        else if (listItem.getPerson().equals(Person.SIMION))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.simion));
            image.setTag(R.drawable.simion);
        }
        else if (listItem.getPerson().equals(Person.FLORIAN))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.florian));
            image.setTag(R.drawable.florian);
        }
        else if (listItem.getPerson().equals(Person.MUELLER))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.pbh_mueller_herr));
            image.setTag(R.drawable.pbh_mueller_herr);
        }
        else if (listItem.getPerson().equals(Person.SAUPE))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.pbh_saupe));
            image.setTag(R.drawable.pbh_saupe);
        }
        else if (listItem.getPerson().equals(Person.BADERSCHNEIDER))
        {
            image.setImageDrawable(activity.getResources().getDrawable(R.drawable.pbh_baderschneider));
            image.setTag(R.drawable.pbh_baderschneider);
        }

        image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                activity.openImage((Integer) image.getTag());
            }
        });

        LinearLayout send_mail = (LinearLayout) view.findViewById(R.id.send_mail);
        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.sendMail(items.get(position));
            }
        });

        return view;
    }

    @Override
    public PersonListItem getItem(int position) {
        return items.get(position);
    }
}
