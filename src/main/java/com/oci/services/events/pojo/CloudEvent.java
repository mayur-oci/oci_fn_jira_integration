
package com.oci.services.events.pojo;

import java.io.Serializable;

public class CloudEvent implements Serializable
{

    private String cloudEventsVersion;
    private String eventId;
    private String eventType;
    private String source;
    private String eventTypeVersion;
    private String eventTime;
    private String contentType;
    private Extensions extensions;
    private Data data;
    private final static long serialVersionUID = -2393792103060544654L;

    public String getCloudEventsVersion() {
        return cloudEventsVersion;
    }

    public void setCloudEventsVersion(String cloudEventsVersion) {
        this.cloudEventsVersion = cloudEventsVersion;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getEventTypeVersion() {
        return eventTypeVersion;
    }

    public void setEventTypeVersion(String eventTypeVersion) {
        this.eventTypeVersion = eventTypeVersion;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Extensions getExtensions() {
        return extensions;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}
