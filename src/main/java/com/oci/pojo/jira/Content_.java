
package com.oci.pojo.jira;

import java.io.Serializable;

public class Content_ implements Serializable
{

    private String text;
    private String type;
    private final static long serialVersionUID = -8468734653974000719L;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
