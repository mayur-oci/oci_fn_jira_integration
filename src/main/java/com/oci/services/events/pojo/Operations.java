
package com.oci.services.events.pojo;

import java.io.Serializable;

public class Operations implements Serializable
{

    private String costCenter;
    private final static long serialVersionUID = 6322772388163829781L;

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

}
