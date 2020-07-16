
package com.oci.services.events.pojo;

import java.io.Serializable;

public class FreeFormTags implements Serializable
{

    private String department;
    private final static long serialVersionUID = 830795066328802911L;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
