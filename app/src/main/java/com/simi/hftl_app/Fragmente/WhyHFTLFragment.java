package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.TextSize;
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

        TextView beginningText = (TextView) view.findViewById(R.id.why_hftl_text);
        TextView titleFragment = (TextView) view.findViewById(R.id.title_fragment);
        TextView title_reason_one = (TextView) view.findViewById(R.id.title_why_one);
        TextView title_reason_two = (TextView) view.findViewById(R.id.title_why_two);
        TextView title_reason_three = (TextView) view.findViewById(R.id.title_why_three);
        TextView title_reason_four = (TextView) view.findViewById(R.id.title_why_four);
        TextView title_reason_five = (TextView) view.findViewById(R.id.title_why_five);
        TextView title_reason_six = (TextView) view.findViewById(R.id.title_why_six);
        TextView title_reason_seven = (TextView) view.findViewById(R.id.title_why_seven);

        TextView reason_one = (TextView) view.findViewById(R.id.text_why_one);
        TextView reason_two = (TextView) view.findViewById(R.id.text_why_two);
        TextView reason_three = (TextView) view.findViewById(R.id.text_why_three);
        TextView reason_four = (TextView) view.findViewById(R.id.text_why_four);
        TextView reason_five = (TextView) view.findViewById(R.id.text_why_five);
        TextView reason_six = (TextView) view.findViewById(R.id.text_why_six);
        TextView reason_seven = (TextView) view.findViewById(R.id.text_why_seven);

        beginningText.setText(getActivity().getResources().getString(R.string.why_hftl_text));
        titleFragment.setText(getActivity().getResources().getString(R.string.WHY_HFTL_TITLE));
        title_reason_one.setText(getActivity().getResources().getString(R.string.title_reason_one));
        title_reason_two.setText(getActivity().getResources().getString(R.string.title_reason_two));
        title_reason_three.setText(getActivity().getResources().getString(R.string.title_reason_three));
        title_reason_four.setText(getActivity().getResources().getString(R.string.title_reason_four));
        title_reason_five.setText(getActivity().getResources().getString(R.string.title_reason_five));
        title_reason_six.setText(getActivity().getResources().getString(R.string.title_reason_six));
        title_reason_seven.setText(getActivity().getResources().getString(R.string.title_reason_seven));

        reason_one.setText(getActivity().getResources().getString(R.string.reason_one));
        reason_two.setText(getActivity().getResources().getString(R.string.reason_two));
        reason_three.setText(getActivity().getResources().getString(R.string.reason_three));
        reason_four.setText(getActivity().getResources().getString(R.string.reason_four));
        reason_five.setText(getActivity().getResources().getString(R.string.reason_five));
        reason_six.setText(getActivity().getResources().getString(R.string.reason_six));
        reason_seven.setText(getActivity().getResources().getString(R.string.reason_seven));

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();
        if (color != 0)
        {
            layout.setBackgroundColor(color);
            title_reason_one.setTextColor(color);
            title_reason_two.setTextColor(color);
            title_reason_three.setTextColor(color);
            title_reason_four.setTextColor(color);
            title_reason_five.setTextColor(color);
            title_reason_six.setTextColor(color);
            title_reason_seven.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.hftl_info_color);
            layout.setBackgroundColor(color);
            title_reason_one.setTextColor(color);
            title_reason_two.setTextColor(color);
            title_reason_three.setTextColor(color);
            title_reason_four.setTextColor(color);
            title_reason_five.setTextColor(color);
            title_reason_six.setTextColor(color);
            title_reason_seven.setTextColor(color);
        }

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title_reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            beginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title_reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            beginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            titleFragment.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title_reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            beginningText.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_one.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_two.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_three.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_four.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_five.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_six.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            reason_seven.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
        }

        return view;
    }
}
