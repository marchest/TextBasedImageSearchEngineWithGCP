package com.vision.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextDetectionResponse {
	private List<TextAnnotation> textAnnotations = null;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public List<TextAnnotation> getTextAnnotations() {
	return textAnnotations;
	}

	public void setTextAnnotations(List<TextAnnotation> textAnnotations) {
	this.textAnnotations = textAnnotations;
	}

	public Map<String, Object> getAdditionalProperties() {
	return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
	this.additionalProperties.put(name, value);
}
}
