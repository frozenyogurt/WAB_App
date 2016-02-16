package com.simi.hftl_app.Fragmente;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by student on 16.02.2016.
 */
public class MyRefreshFragment extends Fragment
{
    public void refresh()
    {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }
}
