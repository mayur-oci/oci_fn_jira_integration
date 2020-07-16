
package com.oci.services.events.pojo;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lifecycleState",
    "timeCreated",
    "timeUpdated",
    "dbUniqueName",
    "dbHomeId",
    "dbName"
})
public class AdditionalDetails implements Serializable
{

    @JsonProperty("lifecycleState")
    private String lifecycleState;
    @JsonProperty("timeCreated")
    private String timeCreated;
    @JsonProperty("timeUpdated")
    private String timeUpdated;
    @JsonProperty("dbUniqueName")
    private String dbUniqueName;
    @JsonProperty("dbHomeId")
    private String dbHomeId;
    @JsonProperty("dbName")
    private String dbName;
    private final static long serialVersionUID = 7482413845610182821L;

    @JsonProperty("lifecycleState")
    public String getLifecycleState() {
        return lifecycleState;
    }

    @JsonProperty("lifecycleState")
    public void setLifecycleState(String lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    @JsonProperty("timeCreated")
    public String getTimeCreated() {
        return timeCreated;
    }

    @JsonProperty("timeCreated")
    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    @JsonProperty("timeUpdated")
    public String getTimeUpdated() {
        return timeUpdated;
    }

    @JsonProperty("timeUpdated")
    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    @JsonProperty("dbUniqueName")
    public String getDbUniqueName() {
        return dbUniqueName;
    }

    @JsonProperty("dbUniqueName")
    public void setDbUniqueName(String dbUniqueName) {
        this.dbUniqueName = dbUniqueName;
    }

    @JsonProperty("dbHomeId")
    public String getDbHomeId() {
        return dbHomeId;
    }

    @JsonProperty("dbHomeId")
    public void setDbHomeId(String dbHomeId) {
        this.dbHomeId = dbHomeId;
    }

    @JsonProperty("dbName")
    public String getDbName() {
        return dbName;
    }

    @JsonProperty("dbName")
    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
