package eu.nurenur.api.models;

import java.util.ArrayList;

public class Image {
    // REIMPLEMENT BETTER!!
    private static int nextID;
    private int id;
    private String title;
    private String description;
    private ArrayList<String> tags;
    private String date;

    public Image() {}

    public Image(String title, String description, ArrayList<String> tags, String date)  {
        this.id = nextID;
        nextID++;
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
