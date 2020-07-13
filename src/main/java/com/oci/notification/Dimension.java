
package com.oci.notification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Dimension implements Serializable
{

    private String instancePoolId;
    private String resourceDisplayName;
    private String faultDomain;
    private String resourceId;
    private String availabilityDomain;
    private String imageId;
    private String region;
    private String shape;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7124360329351874951L;

    public String getInstancePoolId() {
        return instancePoolId;
    }

    public void setInstancePoolId(String instancePoolId) {
        this.instancePoolId = instancePoolId;
    }

    public String getResourceDisplayName() {
        return resourceDisplayName;
    }

    public void setResourceDisplayName(String resourceDisplayName) {
        this.resourceDisplayName = resourceDisplayName;
    }

    public String getFaultDomain() {
        return faultDomain;
    }

    public void setFaultDomain(String faultDomain) {
        this.faultDomain = faultDomain;
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

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
