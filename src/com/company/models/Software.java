package com.company.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Software implements Serializable {
    private String name;
    private ArrayList<SoftwareVersion> versions;

    public Software(String name, ArrayList<SoftwareVersion> versions) {
        this.name = name;
        this.versions = versions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SoftwareVersion> getVersions() {
        return versions;
    }
}
