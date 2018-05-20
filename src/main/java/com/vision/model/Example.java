package com.vision.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example {

    private List<LabelDetectionResponse> responses = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<LabelDetectionResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<LabelDetectionResponse> responses) {
        this.responses = responses;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
