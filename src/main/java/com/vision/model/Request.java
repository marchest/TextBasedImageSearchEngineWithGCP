package com.vision.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Request {

    private Image image;
    private List<Feature> features = null;
   

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

  

}
