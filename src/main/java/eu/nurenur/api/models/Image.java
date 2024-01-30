package eu.nurenur.api.models;

import java.util.ArrayList;

public class Image {
    int id;
    String title;
    String description;
    ArrayList<String> tags;
    String date;
    // ArrayList<Character> characters;

    public Image() {}

    public Image(String title, String description, ArrayList<String> tags, String date)  {
        this.title = title;
        this.description = description;
        this.tags = tags;
        this.date = date;
    }
}
