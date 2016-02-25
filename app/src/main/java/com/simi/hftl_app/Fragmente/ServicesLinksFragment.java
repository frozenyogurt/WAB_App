package com.simi.hftl_app.Fragmente;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.simi.hftl_app.Listen.ServicesLinkListAdapter;
import com.simi.hftl_app.Listen.ServicesLinksListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

import java.util.ArrayList;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesLinksFragment extends MyRefreshFragment
{
    public ServicesLinksFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_links_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.title_services_links);
        title.setText(getActivity().getResources().getString(R.string.SERVICES_LINKS_TITLE));

        ListView list = (ListView) view.findViewById(R.id.services_links_list);
        final ArrayList<ServicesLinksListItem> links = new ArrayList<>();
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_ILIAS), "https://ilias.hft-leipzig.de/"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_OWA), "https://owa.hft-leipzig.de/"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_HIS), "https://qisweb.hispro.de/tel/rds?state=user&type=0"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_IEEE), "http://ieeexplore.ieee.org/"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_SPRINGER), "http://rd.springer.com/"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_STATISTA), "http://de.statista.com/"));
        links.add(new ServicesLinksListItem(getActivity().getResources().getString(R.string.SERVICES_LINKS_STUDY_FACTORY), "http://www.studentenwerk-leipzig.de/"));
        ServicesLinkListAdapter adapter = new ServicesLinkListAdapter((MainActivity)getActivity(),R.layout.services_links_list_item,links);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((MainActivity)getActivity()).goToWebsite(links.get(position).getWebsiteLink());
            }
        });

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            list.setDivider(new ColorDrawable(color));
            list.setDividerHeight(5);
        }

        return view;
    }
}
