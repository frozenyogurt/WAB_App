package com.simi.hftl_app.Listen;

/**
 * Created by student on 16.02.2016.
 */
public class ServicesLinksListItem
{
    private String name;
    private String websiteLink;

    public ServicesLinksListItem (String name, String website)
    {
        this.name = name;
        this.websiteLink = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }
}
