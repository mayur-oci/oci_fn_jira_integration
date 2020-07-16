
package com.oci.services.events.pojo;

import java.io.Serializable;

public class DefinedTags implements Serializable
{

    private Operations operations;
    private final static long serialVersionUID = 5916185452290726251L;

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

}
