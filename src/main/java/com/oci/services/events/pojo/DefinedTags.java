
package com.oci.services.events.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Operations"
})
public class DefinedTags implements Serializable
{

    @JsonProperty("Operations")
    private Operations operations;
    private final static long serialVersionUID = 5916185452290726251L;

    @JsonProperty("Operations")
    public Operations getOperations() {
        return operations;
    }

    @JsonProperty("Operations")
    public void setOperations(Operations operations) {
        this.operations = operations;
    }

}
