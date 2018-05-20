package com.vision.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LabelDetectionResponse {

    private List<LabelAnnotation> labelAnnotations = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<LabelAnnotation> getLabelAnnotations() {
        return labelAnnotations;
    }

    public void setLabelAnnotations(List<LabelAnnotation> labelAnnotations) {
        this.labelAnnotations = labelAnnotations;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
