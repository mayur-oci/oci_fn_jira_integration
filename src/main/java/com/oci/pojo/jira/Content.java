
package com.oci.pojo.jira;

import java.io.Serializable;
import java.util.List;

public class Content implements Serializable
{

    private String type;
    private List<Content_> content = null;
    private final static long serialVersionUID = 6234195875223823726L;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Content_> getContent() {
        return content;
    }

    public void setContent(List<Content_> content) {
        this.content = content;
    }

}
