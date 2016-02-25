package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class PortraitHFTLFragment extends MyRefreshFragment
{
    public PortraitHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.portrait_hftl_fragment,container,false);

        TextView title = (TextView) view.findViewById(R.id.title_portrait);
        title.setText(getActivity().getResources().getString(R.string.PORTRAIT_TITLE));

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
        }

        TextView textOne = (TextView) view.findViewById(R.id.portrait_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.portrait_text_two);
        ImageView imageOne = (ImageView) view.findViewById(R.id.portrait_image_one);
        ImageView imageTwo = (ImageView) view.findViewById(R.id.portrait_image_two);

        textOne.setText("Portrait Text");
        textTwo.setText("Portrait Text");
        imageOne.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.news_pic_test));
        imageTwo.setImageDrawable(getActivity().getResources().getDrawable(R.drawable.news_pic_test));

        return view;
    }
}
