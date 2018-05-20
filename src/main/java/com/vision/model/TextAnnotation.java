package com.vision.model;



import java.util.HashMap;
import java.util.Map;

public class TextAnnotation {

    private String locale;
    private String description;
    private BoundingPoly boundingPoly;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BoundingPoly getBoundingPoly() {
        return boundingPoly;
    }

    public void setBoundingPoly(BoundingPoly boundingPoly) {
        this.boundingPoly = boundingPoly;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
