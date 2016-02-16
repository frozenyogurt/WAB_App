package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.simi.hftl_app.Listen.NewsListAdapter;
import com.simi.hftl_app.Listen.NewsListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesRoomsFragment extends MyRefreshFragment
{
    public ServicesRoomsFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_rooms_fragment,container,false);

        ListView list = (ListView) view.findViewById(R.id.services_rooms_list);
        ArrayList<NewsListItem> news = new ArrayList<>();
        news.add(new NewsListItem("Raum Titel",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.",
                R.drawable.news_pic_test));
        news.add(new NewsListItem("Raum Titel",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.",
                R.drawable.news_pic_test));
        news.add(new NewsListItem("Raum Titel",
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.",
                R.drawable.news_pic_test));
        NewsListAdapter adapter = new NewsListAdapter((MainActivity)getActivity(),R.layout.news_list_item,news);
        list.setAdapter(adapter);

        return view;
    }
}
