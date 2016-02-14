package com.simi.hftl_app.Listen;

/**
 * Created by student on 13.02.2016.
 */
public class NewsListItem
{
    private String title;
    private String message;
    private int pictureID;

    public NewsListItem(String title, String message, int id)
    {
        this.message = message;
        this.pictureID = id;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPictureID() {
        return pictureID;
    }

    public void setPictureID(int pictureID) {
        this.pictureID = pictureID;
    }
}
