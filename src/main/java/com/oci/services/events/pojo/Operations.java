
package com.oci.services.events.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CostCenter"
})
public class Operations implements Serializable
{

    @JsonProperty("CostCenter")
    private String costCenter;
    private final static long serialVersionUID = 6322772388163829781L;

    @JsonProperty("CostCenter")
    public String getCostCenter() {
        return costCenter;
    }

    @JsonProperty("CostCenter")
    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

}
