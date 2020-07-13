
package com.oci.notification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlarmMetaData implements Serializable
{

    private String id;
    private String status;
    private String severity;
    private String query;
    private Integer totalMetricsFiring;
    private List<Dimension> dimensions = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8711319228745586032L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getTotalMetricsFiring() {
        return totalMetricsFiring;
    }

    public void setTotalMetricsFiring(Integer totalMetricsFiring) {
        this.totalMetricsFiring = totalMetricsFiring;
    }

    public List<Dimension> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<Dimension> dimensions) {
        this.dimensions = dimensions;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "AlarmMetaData{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", severity='" + severity + '\'' +
                ", query='" + query + '\'' +
                ", totalMetricsFiring=" + totalMetricsFiring +
                ", dimensions=" + dimensions +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
