
package com.oci.services.events.pojo;

import java.io.Serializable;

public class AdditionalDetails implements Serializable
{

    private String lifecycleState;
    private String timeCreated;
    private String timeUpdated;
    private String dbUniqueName;
    private String dbHomeId;
    private String dbName;
    private final static long serialVersionUID = 7482413845610182821L;

    public String getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(String lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    public String getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(String timeCreated) {
        this.timeCreated = timeCreated;
    }

    public String getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(String timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getDbUniqueName() {
        return dbUniqueName;
    }

    public void setDbUniqueName(String dbUniqueName) {
        this.dbUniqueName = dbUniqueName;
    }

    public String getDbHomeId() {
        return dbHomeId;
    }

    public void setDbHomeId(String dbHomeId) {
        this.dbHomeId = dbHomeId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
