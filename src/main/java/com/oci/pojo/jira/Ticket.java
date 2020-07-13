
package com.oci.pojo.jira;

import java.io.Serializable;

public class Ticket implements Serializable
{

    private Fields fields;
    private final static long serialVersionUID = 4552182322283923906L;

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

}
