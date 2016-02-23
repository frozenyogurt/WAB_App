package com.simi.hftl_app.Listen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.QuestionFragments.Question10Fragment;
import com.simi.hftl_app.QuestionFragments.Question11Fragment;
import com.simi.hftl_app.QuestionFragments.Question12Fragment;
import com.simi.hftl_app.QuestionFragments.Question13Fragment;
import com.simi.hftl_app.QuestionFragments.Question14Fragment;
import com.simi.hftl_app.QuestionFragments.Question15Fragment;
import com.simi.hftl_app.QuestionFragments.Question1Fragment;
import com.simi.hftl_app.QuestionFragments.Question2Fragment;
import com.simi.hftl_app.QuestionFragments.Question3Fragment;
import com.simi.hftl_app.QuestionFragments.Question4Fragment;
import com.simi.hftl_app.QuestionFragments.Question5Fragment;
import com.simi.hftl_app.QuestionFragments.Question6Fragment;
import com.simi.hftl_app.QuestionFragments.Question7Fragment;
import com.simi.hftl_app.QuestionFragments.Question8Fragment;
import com.simi.hftl_app.QuestionFragments.Question9Fragment;

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
            return new Question1Fragment();
        }
        else if (position == 1)
        {
            return new Question2Fragment();
        }
        else if (position == 2)
        {
            return new Question3Fragment();
        }
        else if (position == 3)
        {
            return new Question4Fragment();
        }
        else if (position == 4)
        {
            return new Question5Fragment();
        }
        else if (position == 5)
        {
            return new Question6Fragment();
        }
        else if (position == 6)
        {
            return new Question7Fragment();
        }
        else if (position == 7)
        {
            return new Question8Fragment();
        }
        else if (position == 8)
        {
            return new Question9Fragment();
        }
        else if (position == 9)
        {
            return new Question10Fragment();
        }
        else if (position == 10)
        {
            return new Question11Fragment();
        }
        else if (position ==11)
        {
            return new Question12Fragment();
        }
        else if (position == 12)
        {
            return new Question13Fragment();
        }
        else if (position == 13)
        {
            return new Question14Fragment();
        }
        else
        {
            return new Question15Fragment();
        }
    }

    @Override
    public int getCount() {
        return activity.getQuestions().size();
    }
}
