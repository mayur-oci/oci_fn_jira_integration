
package com.oci.services.events.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cloudEventsVersion",
    "eventId",
    "eventType",
    "source",
    "eventTypeVersion",
    "eventTime",
    "contentType",
    "extensions",
    "data"
})
public class CloudEvent implements Serializable
{

    @JsonProperty("cloudEventsVersion")
    private String cloudEventsVersion;
    @JsonProperty("eventId")
    private String eventId;
    @JsonProperty("eventType")
    private String eventType;
    @JsonProperty("source")
    private String source;
    @JsonProperty("eventTypeVersion")
    private String eventTypeVersion;
    @JsonProperty("eventTime")
    private String eventTime;
    @JsonProperty("contentType")
    private String contentType;
    @JsonProperty("extensions")
    private Extensions extensions;
    @JsonProperty("data")
    private Data data;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 6578589834696540318L;

    @JsonProperty("cloudEventsVersion")
    public String getCloudEventsVersion() {
        return cloudEventsVersion;
    }

    @JsonProperty("cloudEventsVersion")
    public void setCloudEventsVersion(String cloudEventsVersion) {
        this.cloudEventsVersion = cloudEventsVersion;
    }

    @JsonProperty("eventId")
    public String getEventId() {
        return eventId;
    }

    @JsonProperty("eventId")
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    @JsonProperty("eventType")
    public String getEventType() {
        return eventType;
    }

    @JsonProperty("eventType")
    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("eventTypeVersion")
    public String getEventTypeVersion() {
        return eventTypeVersion;
    }

    @JsonProperty("eventTypeVersion")
    public void setEventTypeVersion(String eventTypeVersion) {
        this.eventTypeVersion = eventTypeVersion;
    }

    @JsonProperty("eventTime")
    public String getEventTime() {
        return eventTime;
    }

    @JsonProperty("eventTime")
    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    @JsonProperty("contentType")
    public String getContentType() {
        return contentType;
    }

    @JsonProperty("contentType")
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @JsonProperty("extensions")
    public Extensions getExtensions() {
        return extensions;
    }

    @JsonProperty("extensions")
    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
