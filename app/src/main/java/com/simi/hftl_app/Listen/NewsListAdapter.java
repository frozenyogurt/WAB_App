package com.simi.hftl_app.Listen;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by student on 13.02.2016.
 */
public class NewsListAdapter extends ArrayAdapter<NewsListItem>
{
    private final LayoutInflater inflater;
    private final MainActivity activity;
    private final ArrayList<NewsListItem> items;

    public NewsListAdapter (MainActivity activity, int resource, ArrayList<NewsListItem> items)
    {
        super(activity.getApplicationContext(), resource, items);
        this.inflater = (LayoutInflater) activity.getSystemService(LAYOUT_INFLATER_SERVICE);
        this.activity = activity;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = inflater.inflate(R.layout.news_list_item, parent, false);
        NewsListItem listItem = items.get(position);

        ImageView picture = (ImageView) view.findViewById(R.id.news_image);
        picture.setImageDrawable(activity.getResources().getDrawable(listItem.getPictureID()));

        TextView message = (TextView) view.findViewById(R.id.news_massage);
        message.setText(listItem.getMessage());

        TextView title = (TextView) view.findViewById(R.id.news_title);
        title.setText(listItem.getTitle());

        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            message.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            message.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            message.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return view;
    }
}
