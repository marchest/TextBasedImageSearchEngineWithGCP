package com.xas.common.AppUtils;

import javax.persistence.AttributeConverter;

import com.xas.common.model.State;


public class StateConverter implements AttributeConverter<State, String>{

	public String convertToDatabaseColumn(State attribute) {
		switch (attribute) {
		case ACTIVE:
			return "ACTIVE";
			
		case PASSIVE:
			return "PASSIVE";
			
		default:
			 throw new IllegalArgumentException("Unknown" + attribute);
			 }
		
	}

	public State convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "ACTIVE":
			return State.ACTIVE;
		case "PASSIVE":
			return State.PASSIVE;
		default:
			 throw new IllegalArgumentException("Unknown" + dbData);
		}
	}

}
