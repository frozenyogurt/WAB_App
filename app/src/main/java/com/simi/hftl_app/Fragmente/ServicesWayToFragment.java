package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class ServicesWayToFragment extends Fragment
{
    public ServicesWayToFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.services_way_to_fragment,container,false);
        return view;
    }
}
