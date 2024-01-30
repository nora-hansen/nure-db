package eu.nurenur.api.controllers;

import eu.nurenur.api.models.Image;
import eu.nurenur.api.repositories.ImageRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("images")
public class ImageController {
    ImageRepository imageRepo;

    public ImageController()    {
        this.imageRepo = new ImageRepository();
    }

    @GetMapping
    public ArrayList<Image> getAll()    {
        return this.imageRepo.findAll();
    }

    @GetMapping("{id}")
    public Image getOne(@PathVariable int id)   {
        if(this.imageRepo.findOne(id) == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Image not found");
        return this.imageRepo.findOne(id);
    }


}
