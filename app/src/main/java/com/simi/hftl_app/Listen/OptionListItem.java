package com.simi.hftl_app.Listen;

import com.simi.hftl_app.Model.Option;

/**
 * Created by student on 10.02.2016.
 */
public class OptionListItem
{
    private String name;
    private Option option;

    public OptionListItem(String name, Option option)
    {
        this.name = name;
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }
}
