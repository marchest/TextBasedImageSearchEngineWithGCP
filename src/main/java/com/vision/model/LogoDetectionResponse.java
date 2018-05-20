
package com.vision.model;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogoDetectionResponse {

    private List<LogoAnnotation> logoAnnotations = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<LogoAnnotation> getLogoAnnotations() {
        return logoAnnotations;
    }

    public void setLogoAnnotations(List<LogoAnnotation> logoAnnotations) {
        this.logoAnnotations = logoAnnotations;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
