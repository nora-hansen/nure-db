package eu.nurenur.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("images")
public class ImageController {
    ImageRepository imageRepo;

    public ImageController()    {
        this.imageRepo = new ImageRepository();
    }
}
