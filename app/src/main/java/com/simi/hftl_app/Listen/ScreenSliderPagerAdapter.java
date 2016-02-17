package com.simi.hftl_app.Listen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.simi.hftl_app.Fragmente.FirstQuestionFragment;
import com.simi.hftl_app.Fragmente.QuestionFragment;
import com.simi.hftl_app.Main.MainActivity;

/**
 * Created by student on 17.02.2016.
 */
public class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter
{
    MainActivity activity;

    public ScreenSliderPagerAdapter(FragmentManager fm, MainActivity activity)
    {
        super(fm);
        this.activity = activity;
    }

    @Override
    public Fragment getItem(int position)
    {
        activity.setCurrentPage(position);
        if (position == 0)
        {
            return new FirstQuestionFragment();
        }
        else
        {
            return new QuestionFragment();
        }
    }

    @Override
    public int getCount() {
        return activity.getQuestions().size();
    }
}
