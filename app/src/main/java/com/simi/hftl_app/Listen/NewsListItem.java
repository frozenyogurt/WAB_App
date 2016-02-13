package com.simi.hftl_app.Listen;

/**
 * Created by student on 13.02.2016.
 */
public class NewsListItem
{
    private String title;
    private String messageRight;
    private String messageUnder;
    private int pictureID;

    public NewsListItem(String title, String messageRight, String messageUnder, int id)
    {
        this.messageRight = messageRight;
        this.messageUnder = messageUnder;
        this.pictureID = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessageRight() {
        return messageRight;
    }

    public void setMessageRight(String messageRight) {
        this.messageRight = messageRight;
    }

    public String getMessageUnder() {
        return messageUnder;
    }

    public void setMessageUnder(String messageUnder) {
        this.messageUnder = messageUnder;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }
}
