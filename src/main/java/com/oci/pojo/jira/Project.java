
package com.oci.pojo.jira;

import java.io.Serializable;

public class Project implements Serializable
{

    private String key;
    private final static long serialVersionUID = 949702004594316863L;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
