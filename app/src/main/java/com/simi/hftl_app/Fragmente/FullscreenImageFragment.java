package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.R;

/**
 * Created by student on 03.03.2016.
 */
public class FullscreenImageFragment extends MyRefreshFragment
{
    public FullscreenImageFragment () {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.image_fullscreen, container, false);

        ImageView image = (ImageView) view.findViewById(R.id.fullscreen_image);
        image.setImageDrawable(((MainActivity)getActivity()).getImage());

        return view;
    }
}
