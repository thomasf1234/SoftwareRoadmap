package com.company.models;

import java.io.Serializable;
import java.util.Date;

public class SoftwareVersion implements Serializable {
    private String name;
    private Date releaseDate;
    private Date endOfLifeDate;

    public SoftwareVersion(String name, Date releaseDate, Date endOfLifeDate) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.endOfLifeDate = endOfLifeDate;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public Date getEndOfLifeDate() {
        return endOfLifeDate;
    }

    public String getName() {
        return name;
    }
}
