package pl.sdacademy.model;

public class Image {
    private String url = "";
    private String description = "";

    public Image() {
    }

    public Image(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}