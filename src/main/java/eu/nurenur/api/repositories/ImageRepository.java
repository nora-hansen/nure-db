package eu.nurenur.api.repositories;

import eu.nurenur.api.models.Image;

import java.util.ArrayList;

public class ImageRepository {
    private ArrayList<Image> images;

    public ImageRepository()    {
        this.images = new ArrayList<>();
    }

    public ArrayList<Image> findAll()   {
        return this.images;
    }

    public Image findOne(int id)    {
        for(Image image : this.images)  {
            if(image.getId() == id)
                return image;
        }
        return null;
    }
}
