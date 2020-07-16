
package com.oci.services.events.pojo;

import java.io.Serializable;

public class Extensions implements Serializable
{

    private String compartmentId;
    private final static long serialVersionUID = -2884864912097406470L;

    public String getCompartmentId() {
        return compartmentId;
    }

    public void setCompartmentId(String compartmentId) {
        this.compartmentId = compartmentId;
    }

}
