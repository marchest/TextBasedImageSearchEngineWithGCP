package com.vision.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoundingPoly {

    private List<Vertex> vertices = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
