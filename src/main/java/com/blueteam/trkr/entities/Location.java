package com.blueteam.trkr.entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Location
 *
 */
@Entity

public class Location implements Serializable {

    @Id
    private Float id;
    private Float gpsLatitute;
    private Float gpsLongitude;
    private String name;

    @Enumerated(EnumType.STRING)
    private TYPE locationType;

    private static final long serialVersionUID = 1L;

    public Location() {
        this.locationType = TYPE.MOUTAIN;
    }

    public Float getId() {
        return this.id;
    }

    public void setId(Float id) {
        this.id = id;
    }

    public Float getGpsLatitute() {
        return this.gpsLatitute;
    }

    public void setGpsLatitute(Float gpsLatitute) {
        this.gpsLatitute = gpsLatitute;
    }

    public Float getGpsLongitude() {
        return this.gpsLongitude;
    }

    public void setGpsLongitude(Float gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getLocationType() {
        return locationType;
    }

    public void setLocationType(TYPE locationType) {
        this.locationType = locationType;
    }
}
