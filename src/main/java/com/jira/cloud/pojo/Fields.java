
package com.jira.cloud.pojo;

import java.io.Serializable;

public class Fields implements Serializable
{

    private String summary;
    private Issuetype issuetype;
    private Project project;
    private Description description;
    private final static long serialVersionUID = -4688943236273491700L;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Issuetype getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
