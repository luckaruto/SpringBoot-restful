package com.webservice.IeltsWeb.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExtendedIfo extends CourseDTO {
	
	@JsonProperty("OwnerID") 
	private String additionalVariable;

    public String getAdditionalVariable() {
        return additionalVariable;
    }

    public void setAdditionalVariable(String additionalVariable) {
        this.additionalVariable = additionalVariable;
    }

}
