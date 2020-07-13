
package com.oci.pojo.jira;

import java.io.Serializable;

public class Issuetype implements Serializable
{

    private String id;
    private final static long serialVersionUID = -4694751411770616128L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
