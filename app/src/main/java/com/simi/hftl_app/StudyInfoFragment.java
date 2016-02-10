package com.simi.hftl_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by student on 10.02.2016.
 */
public class StudyInfoFragment extends Fragment
{
    public StudyInfoFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.study_info_fragment, container, false);

        StudyListItem element = ((MainActivity) getActivity()).getClickedElement();
        TextView title = (TextView) view.findViewById(R.id.infoStudyTitle);
        title.setText(element.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.TitleUndeline);
        TextView titleJob = (TextView) view.findViewById(R.id.jobPerspectivesTitle);
        TextView titleCurri = (TextView) view.findViewById(R.id.curriculumTitle);
        if (element.getCategory().equals(Category.NORMAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_color));
        }
        else if (element.getCategory().equals(Category.DUAL))
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_dual_color));
        }
        else
        {
            layout.setBackgroundColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleJob.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
            titleCurri.setTextColor(getActivity().getResources().getColor(R.color.study_job_color));
        }

        return view;
    }
}
