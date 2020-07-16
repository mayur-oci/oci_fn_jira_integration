
package com.oci.services.events.pojo;

import java.io.Serializable;

public class Data implements Serializable
{

    private String compartmentId;
    private String compartmentName;
    private String resourceName;
    private String resourceId;
    private String availabilityDomain;
    private FreeFormTags freeFormTags;
    private DefinedTags definedTags;
    private AdditionalDetails additionalDetails;
    private final static long serialVersionUID = 792984759388253274L;

    public String getCompartmentId() {
        return compartmentId;
    }

    public void setCompartmentId(String compartmentId) {
        this.compartmentId = compartmentId;
    }

    public String getCompartmentName() {
        return compartmentName;
    }

    public void setCompartmentName(String compartmentName) {
        this.compartmentName = compartmentName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getAvailabilityDomain() {
        return availabilityDomain;
    }

    public void setAvailabilityDomain(String availabilityDomain) {
        this.availabilityDomain = availabilityDomain;
    }

    public FreeFormTags getFreeFormTags() {
        return freeFormTags;
    }

    public void setFreeFormTags(FreeFormTags freeFormTags) {
        this.freeFormTags = freeFormTags;
    }

    public DefinedTags getDefinedTags() {
        return definedTags;
    }

    public void setDefinedTags(DefinedTags definedTags) {
        this.definedTags = definedTags;
    }

    public AdditionalDetails getAdditionalDetails() {
        return additionalDetails;
    }

    public void setAdditionalDetails(AdditionalDetails additionalDetails) {
        this.additionalDetails = additionalDetails;
    }

}
