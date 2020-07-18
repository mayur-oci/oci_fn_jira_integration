
package com.oci.services.events.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "compartmentId",
    "compartmentName",
    "resourceName",
    "resourceId",
    "availabilityDomain",
    "freeFormTags",
    "definedTags",
    "additionalDetails"
})
public class Data implements Serializable
{

    @JsonProperty("compartmentId")
    private String compartmentId;
    @JsonProperty("compartmentName")
    private String compartmentName;
    @JsonProperty("resourceName")
    private String resourceName;
    @JsonProperty("resourceId")
    private String resourceId;
    @JsonProperty("availabilityDomain")
    private String availabilityDomain;
    @JsonProperty("freeFormTags")
    private FreeFormTags freeFormTags;
    @JsonProperty("definedTags")
    private DefinedTags definedTags;
    @JsonProperty("additionalDetails")
    private AdditionalDetails additionalDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6106870108660257291L;

    @JsonProperty("compartmentId")
    public String getCompartmentId() {
        return compartmentId;
    }

    @JsonProperty("compartmentId")
    public void setCompartmentId(String compartmentId) {
        this.compartmentId = compartmentId;
    }

    @JsonProperty("compartmentName")
    public String getCompartmentName() {
        return compartmentName;
    }

    @JsonProperty("compartmentName")
    public void setCompartmentName(String compartmentName) {
        this.compartmentName = compartmentName;
    }

    @JsonProperty("resourceName")
    public String getResourceName() {
        return resourceName;
    }

    @JsonProperty("resourceName")
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @JsonProperty("resourceId")
    public String getResourceId() {
        return resourceId;
    }

    @JsonProperty("resourceId")
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    @JsonProperty("availabilityDomain")
    public String getAvailabilityDomain() {
        return availabilityDomain;
    }

    @JsonProperty("availabilityDomain")
    public void setAvailabilityDomain(String availabilityDomain) {
        this.availabilityDomain = availabilityDomain;
    }

    @JsonProperty("freeFormTags")
    public FreeFormTags getFreeFormTags() {
        return freeFormTags;
    }

    @JsonProperty("freeFormTags")
    public void setFreeFormTags(FreeFormTags freeFormTags) {
        this.freeFormTags = freeFormTags;
    }

    @JsonProperty("definedTags")
    public DefinedTags getDefinedTags() {
        return definedTags;
    }

    @JsonProperty("definedTags")
    public void setDefinedTags(DefinedTags definedTags) {
        this.definedTags = definedTags;
    }

    @JsonProperty("additionalDetails")
    public AdditionalDetails getAdditionalDetails() {
        return additionalDetails;
    }

    @JsonProperty("additionalDetails")
    public void setAdditionalDetails(AdditionalDetails additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
