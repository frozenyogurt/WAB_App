package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class WhyHFTLFragment extends MyRefreshFragment
{
    public WhyHFTLFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.why_hftl_fragment,container,false);

        TextView text = (TextView) view.findViewById(R.id.why_hftl_text);
        text.setText(getActivity().getResources().getString(R.string.why_hftl_text));

        return view;
    }
}
