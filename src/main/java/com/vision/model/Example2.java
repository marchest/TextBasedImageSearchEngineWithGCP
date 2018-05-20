package com.vision.model;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example2 {

    private List<Request> requests = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
