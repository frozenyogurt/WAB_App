package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simi.hftl_app.R;

/**
 * Created by student on 09.02.2016.
 */
public class TestStudyFragment extends MyRefreshFragment
{
    public TestStudyFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.test_study_fragment,container,false);
        return view;
    }
}
