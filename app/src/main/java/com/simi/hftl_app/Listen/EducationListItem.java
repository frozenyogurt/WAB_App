package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Model.Education;

/**
 * Created by student on 12.02.2016.
 */
public class EducationListItem
{
    private String name;
    private Education education;

    public EducationListItem(String name, Education education)
    {
        this.name = name;
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
}
