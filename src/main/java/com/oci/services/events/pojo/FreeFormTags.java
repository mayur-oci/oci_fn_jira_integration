
package com.oci.services.events.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Department"
})
public class FreeFormTags implements Serializable
{

    @JsonProperty("Department")
    private String department;
    private final static long serialVersionUID = 830795066328802911L;

    @JsonProperty("Department")
    public String getDepartment() {
        return department;
    }

    @JsonProperty("Department")
    public void setDepartment(String department) {
        this.department = department;
    }

}
