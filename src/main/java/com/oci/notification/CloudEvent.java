
package com.oci.notification;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloudEvent implements Serializable
{

    private String dedupeKey;
    private String title;
    private String type;
    private String severity;
    private Long timestampEpochMillis;
    private List<AlarmMetaData> alarmMetaData = null;
    private Double version;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -8009993063386075224L;

    public String getDedupeKey() {
        return dedupeKey;
    }

    public void setDedupeKey(String dedupeKey) {
        this.dedupeKey = dedupeKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public Long getTimestampEpochMillis() {
        return timestampEpochMillis;
    }

    public void setTimestampEpochMillis(Long timestampEpochMillis) {
        this.timestampEpochMillis = timestampEpochMillis;
    }

    public List<AlarmMetaData> getAlarmMetaData() {
        return alarmMetaData;
    }

    public void setAlarmMetaData(List<AlarmMetaData> alarmMetaData) {
        this.alarmMetaData = alarmMetaData;
    }

    public Double getVersion() {
        return version;
    }

    public void setVersion(Double version) {
        this.version = version;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "CloudEvent{" +
                "dedupeKey='" + dedupeKey + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", severity='" + severity + '\'' +
                ", timestampEpochMillis=" + timestampEpochMillis +
                ", alarmMetaData=" + alarmMetaData +
                ", version=" + version +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
