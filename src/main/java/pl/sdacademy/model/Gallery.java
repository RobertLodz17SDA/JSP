package pl.sdacademy.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Gallery {

    private String name;
    private LinkedList<Image> images;
    private SimpleDateFormat created;

    public Gallery(String requestedName) {
        this.name = requestedName;
        this.images = new LinkedList<>();
        this.created = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public void addImage(String imageLink, String description) {
        Image newImage = new Image(imageLink, description);
        images.add(newImage);
    }

    public LinkedList<Image> getImages() {
        return images;
    }

    public String getName() {
        return name;
    }

    public String getCreated() {
        return created.format(new Date());
    }

    public void setImages(LinkedList<Image> newImages) {
        this.images = newImages;
    }
}
