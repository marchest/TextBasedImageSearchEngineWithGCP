
package com.vision.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebDetection {

    private List<WebEntity> webEntities = null;
    private List<FullMatchingImage> fullMatchingImages = null;
    private List<PartialMatchingImage> partialMatchingImages = null;
    private List<VisuallySimilarImage> visuallySimilarImages = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<WebEntity> getWebEntities() {
        return webEntities;
    }

    public void setWebEntities(List<WebEntity> webEntities) {
        this.webEntities = webEntities;
    }

    public List<FullMatchingImage> getFullMatchingImages() {
        return fullMatchingImages;
    }

    public void setFullMatchingImages(List<FullMatchingImage> fullMatchingImages) {
        this.fullMatchingImages = fullMatchingImages;
    }

    public List<PartialMatchingImage> getPartialMatchingImages() {
        return partialMatchingImages;
    }

    public void setPartialMatchingImages(List<PartialMatchingImage> partialMatchingImages) {
        this.partialMatchingImages = partialMatchingImages;
    }

    public List<VisuallySimilarImage> getVisuallySimilarImages() {
        return visuallySimilarImages;
    }

    public void setVisuallySimilarImages(List<VisuallySimilarImage> visuallySimilarImages) {
        this.visuallySimilarImages = visuallySimilarImages;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
