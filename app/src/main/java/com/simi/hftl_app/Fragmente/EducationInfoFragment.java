package com.simi.hftl_app.Fragmente;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.simi.hftl_app.Listen.EducationListItem;
import com.simi.hftl_app.Main.MainActivity;
import com.simi.hftl_app.Model.Education;
import com.simi.hftl_app.Model.TextSize;
import com.simi.hftl_app.R;

/**
 * Created by student on 12.02.2016.
 */
public class EducationInfoFragment extends MyRefreshFragment
{
    public EducationInfoFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.education_info_fragment, container, false);

        EducationListItem element = ((MainActivity) getActivity()).getClickedEductaion();
        TextView title = (TextView) view.findViewById(R.id.infoEducationTitle);
        title.setText(element.getName());

        TextView beginning = (TextView) view.findViewById(R.id.eductaionBeginningText);
        TextView titleOne = (TextView) view.findViewById(R.id.TOEIC_title_one);
        TextView titleTwo = (TextView) view.findViewById(R.id.TOEIC_title_two);
        TextView titleThree = (TextView) view.findViewById(R.id.TOEIC_title_three);
        TextView textOne = (TextView) view.findViewById(R.id.TOEIC_text_one);
        TextView textTwo = (TextView) view.findViewById(R.id.TOEIC_text_two);
        TextView textThree = (TextView) view.findViewById(R.id.TOEIC_text_three);

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.underline);
        int color = ((MainActivity) getActivity()).convertColorString();

        if (color != 0)
        {
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
        }
        else
        {
            color = getActivity().getResources().getColor(R.color.education_color);
            layout.setBackgroundColor(color);
            titleOne.setTextColor(color);
            titleTwo.setTextColor(color);
            titleThree.setTextColor(color);
        }

        if (element.getEducation().equals(Education.TOEIC))
        {
            beginning.setText(getActivity().getResources().getString(R.string.TOEIC_BEGINNING_TEXT));

            titleOne.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_ONE));
            titleOne.setVisibility(View.VISIBLE);
            titleTwo.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_TWO));
            titleTwo.setVisibility(View.VISIBLE);
            titleThree.setText(getActivity().getResources().getString(R.string.TOEIC_TITLE_THREE));
            titleThree.setVisibility(View.VISIBLE);

            textOne.setText(getActivity().getResources().getString(R.string.TOEIC_COMPLETE_PACKAGE_TEXT));
            textOne.setVisibility(View.VISIBLE);
            textTwo.setText(getActivity().getResources().getString(R.string.TOEIC_LISTENING_AND_READING_TEXT));
            textTwo.setVisibility(View.VISIBLE);
            textThree.setText(getActivity().getResources().getString(R.string.TOEIC_CLASSES_TEXT));
            textThree.setVisibility(View.VISIBLE);
        }
        if (element.getEducation().equals(Education.BEC))
        {
            beginning.setText(getActivity().getResources().getString(R.string.BEC));
        }
        if (element.getEducation().equals(Education.CAE))
        {
            beginning.setText(getActivity().getResources().getString(R.string.CAE));
        }
        if (element.getEducation().equals(Education.IT))
        {
            beginning.setText(getActivity().getResources().getString(R.string.IT));
        }
        if (element.getEducation().equals(Education.ID))
        {
            beginning.setText(getActivity().getResources().getString(R.string.ID));
        }

        MainActivity activity = ((MainActivity)getActivity());
        if (activity.getTextSize().equals(TextSize.MIDDLE))
        {
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_middle));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_middle));
        }
        else if (activity.getTextSize().equals(TextSize.SMALL))
        {
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size));
        }
        else if (activity.getTextSize().equals(TextSize.BIG))
        {
            beginning.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            textThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_text_size_big));
            titleOne.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleTwo.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            titleThree.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
            title.setTextSize(TypedValue.COMPLEX_UNIT_PX, activity.getResources().getDimension(R.dimen.info_title_size_big));
        }

        return view;
    }
}
