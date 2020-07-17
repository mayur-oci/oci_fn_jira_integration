
package com.jira.cloud.pojo;

import java.io.Serializable;
import java.util.List;

public class Description implements Serializable
{

    private String type;
    private Integer version;
    private List<Content> content = null;
    private final static long serialVersionUID = -1188642168803624549L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<Content> getContent() {
        return content;
    }

    public void setContent(List<Content> content) {
        this.content = content;
    }

}
