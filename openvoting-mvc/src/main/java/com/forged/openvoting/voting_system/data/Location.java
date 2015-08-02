package com.forged.openvoting.voting_system.data;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

/**
 * Created by visitor15 on 8/2/15.
 */
public class Location {

    private String id;
    private String name;

    @GeoSpatialIndexed
    private double[] location;

    public Location() {
        this.id = "";
        this.name = "";
        initLocationList(0.0, 0.0);
    }

    public Location(final String name, final double lat, final double lon) {
        this.id = "";
        this.name = name;
        initLocationList(lat, lon);
    }

    public double[] getLocation() {
        return this.location;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setLatitude(final double latitude) {
        this.location[0] = latitude;
    }

    public void setLongitude(final double longitude) {
        this.location[1] = longitude;
    }

    private void initLocationList(final double lat, final double lon) {
        this.location = new double[2];
        this.location[0] = lat;
        this.location[1] = lon;
    }
}
